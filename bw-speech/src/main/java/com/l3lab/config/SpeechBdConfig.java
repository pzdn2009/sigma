package com.l3lab.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 17:18
 * <p>
 * Desc: {描述}
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "bd.oauth2")
public class SpeechBdConfig {
    private String appId;
    private String apiKey;
    private String secretKey;
}
