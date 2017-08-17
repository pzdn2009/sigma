package com.l3lab;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 19:58
 * <p>
 * Desc: 接收語音文件
 */
@ServerEndpoint("/ws/receive_audio")
@Component
public class ReceiveAudioWsHandle {

    private final static Log logger = LogFactory.getLog(ReceiveAudioWsHandle.class);
    static File uploadedFile = null;
    static String fileName = null;
    static FileOutputStream fos = null;
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    // 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<ReceiveAudioWsHandle> clients = new CopyOnWriteArraySet<ReceiveAudioWsHandle>();
    private String filePath = "D:\\download";
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private String currentCommand = "";

    public static synchronized void addOnlineCount() {
        ReceiveAudioWsHandle.onlineCount++;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }

    /**
     * 新的WebSocket请求开启
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        clients.add(this);
        addOnlineCount();
        logger.info("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void processUpload(ByteBuffer msg, boolean last, Session session) {
        logger.info(msg.getClass().toString() + ":" + msg.toString()+"last:"+last);

        if (currentCommand.equals("start")) {
            try {
                // The temporary file that contains our captured audio stream
                File f = new File("out.wav");

                // if the file already exists we append it.
                if (f.exists()) {
                    logger.info("Adding received block to existing file.");

                    // two clips are used to concat the data
                    AudioInputStream clip1 = AudioSystem.getAudioInputStream(f);
                    AudioInputStream clip2 = AudioSystem.getAudioInputStream(new ByteArrayInputStream(msg.array()));

                    // use a sequenceinput to cat them together
                    AudioInputStream appendedFiles =
                            new AudioInputStream(
                                    new SequenceInputStream(clip1, clip2),
                                    clip1.getFormat(),
                                    clip1.getFrameLength() + clip2.getFrameLength());

                    // write out the output to a temporary file
                    AudioSystem.write(appendedFiles,
                            AudioFileFormat.Type.WAVE,
                            new File("out2.wav"));

                    logger.info("out2.wav success");

                    // rename the files and delete the old one
                    File f1 = new File("out.wav");
                    File f2 = new File("out2.wav");
                    f1.delete();
                    f2.renameTo(new File("out.wav"));
                } else {
                    FileOutputStream fOut = new FileOutputStream("out.wav", true);
                    fOut.write(msg.array());
                    fOut.close();
                }
            } catch (Exception e) {
                logger.error("sss:" + e);
            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        if (message.startsWith("start")) {
            // before we start we cleanup anything left over
            //cleanup();
            currentCommand = "start";
        } else if (message.startsWith("stop")) {
            currentCommand = "stop";
        } else if (message.startsWith("clear")) {
            // just remove the current recording
            //cleanup();
        } else if (message.startsWith("analyze")) {
        }

        logger.info(message);
    }


    public void sendMessage(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
    }

    /**
     * WebSocket请求关闭
     */
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        clients.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1

        logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
        System.out.println("socket closed: " + reason.getReasonPhrase());
    }

    @OnError
    public void onError(Throwable thr) {
        logger.error(thr);
        thr.printStackTrace();
    }
}