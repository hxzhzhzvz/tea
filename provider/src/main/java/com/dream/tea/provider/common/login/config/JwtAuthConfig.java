package com.dream.tea.provider.common.login.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yongfa
 */
@Data
@Component
@ConfigurationProperties("tea-user-login-config")
public class JwtAuthConfig {

    /**
     * 私钥
     */
    private String privateKey = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAMTLHpteCmXrKEMrVSipiIObRF3tpcnfvKoFmpWL9ZZ6IewxH7KDDhxv6tUcjjnHrvyPo9oyrqKc3wTiRXWrZ5e8PgsIc3t+gq2e9eZZAEgnZSxQ8mZvCZAHpKMqehcA2sHUTkNXcFJOlkVXAcHZJrmEnVSPgOFgeB14VHPP5qiTAgMBAAECgYEAg3JlNEQBUAhd8Ve9Xxa2b6nDZbX6GjiO7UYm9iLxXJyhkgFR+cveHhKHWefj/CYr9NkBChr2WPnNYZa97JYb76s3RsSTKgjYThBICdUs3QFT6Bv0qJk8Yb2jRjPdJjtXRb/9Y1h3EUg546jZ4XkLBxlCp1mOIWD1qesdgUTtdqkCQQDnlxgV6dAa2jdd8PjZlSV3mlr1fx8m8A6Oa/cwxgTrI2dJIR/y39aslO2yxbBRLkv6DQLRxsAgcI7zHHyH39r3AkEA2YkeNmG/M9qTIN8o/TNv8FUO5EAHRmLhwB4d1juR/EeqmLm8aiuX3Z0hVPXuNAqmUxKccYATiSvZxN3hOEd8RQJBANSkcFIWmKU/Pl08WFH4VymlieUmLuViwArXaWXYPEXnAPwttRcdnhBiwopGaClyGALllXQmSNzAXREuU82ypmsCQQCwJBDso9U4XYHImioMa7v19EmslBPP8H0vHLO4JmAc0MLYC3z+0vGTJoo4yzHnvb/TgDxgwv4Okg0xFSAqe+epAkEAp0a+Qk/mL3nR7c4O4AthR170Y1VRe/KzBI9pLCCdF81xzF9IyvyY1GN6JyuFYfi4QrUDZehAZg/xRC721aEPiQ==";

    /**
     * 公钥
     */
    private String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEyx6bXgpl6yhDK1UoqYiDm0Rd7aXJ37yqBZqVi/WWeiHsMR+ygw4cb+rVHI45x678j6PaMq6inN8E4kV1q2eXvD4LCHN7foKtnvXmWQBIJ2UsUPJmbwmQB6SjKnoXANrB1E5DV3BSTpZFVwHB2Sa5hJ1Uj4DhYHgdeFRzz+aokwIDAQAB";

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

    /**
     * redis key
     */
    private String tokenRedisKeyPrefix = "token:";

    /**
     * redis value
     */
    private String tokenRedisValue = "login";
}
