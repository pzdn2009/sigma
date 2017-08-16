package com.l3lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 20:00
 * <p>
 * Desc: {描述}
 */
@Configuration
public class WebSocketConfig2 {

    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }
}
