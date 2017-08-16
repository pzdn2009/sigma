package com.l3lab;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 19:58
 * <p>
 * Desc: {描述}
 */
@ServerEndpoint("/logWebSocket")
@Component
public class LogWebSocketHandle {

    private final static Log logger =  LogFactory.getLog( LogWebSocketHandle.class );
    /**
     * 新的WebSocket请求开启
     */
    @OnOpen
    public void onOpen(Session session) {
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("---------------->message："+message);
    }

    /**
     * WebSocket请求关闭
     */
    @OnClose
    public void onClose() {
    }

    @OnError
    public void onError(Throwable thr) {
        thr.printStackTrace();
    }
}