package com.dream.tea.provider.common.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yongfa
 */
@Data
@Component
@ConfigurationProperties("tea.user.jwt.config")
public class JwtAuthConfig {

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * token的过期时间，单位秒
     */
    private int userTokenExpireSecond = 60 * 60 * 12;


    /**
     * 允许倾斜时间
     */
    private Long skewSeconds = 60 * 5L;

    /**
     * token的header字段
     */
    private String authKey = "user-auth";
}
