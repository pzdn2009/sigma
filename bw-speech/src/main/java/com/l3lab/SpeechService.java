package com.l3lab;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import com.l3lab.config.SpeechBdConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 17:05
 * <p>
 * Desc: {描述}
 */
@Configuration
public class SpeechService {

    private SpeechBdConfig config;

    @Autowired
    public SpeechService(SpeechBdConfig config) {
        this.config = config;
    }

    public String Run() {
        AipSpeech client = new AipSpeech(config.getAppId(), config.getApiKey(), config.getSecretKey());

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用API
        JSONObject res = client.asr("test.pcm", "pcm", 16000, null);
        System.out.println(res.toString(2));
        return res.toString(2);
    }

    public void synthesis(AipSpeech client) throws IOException {
        // 对本地语音文件进行识别
        String path = "D:\\code\\java-sdk\\speech_sdk\\src\\test\\resources\\16k_test.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);
        // 对语音二进制数据进行识别
        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
        JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes);
        // 对网络上音频进行识别
        String url = "http://somehost/res/16k_test.pcm";
        String callback = "http://callbackhost/aip/dump";
        JSONObject res = client.asr(url, callback, "pcm", 16000, null);
        System.out.println(res);
    }
}
