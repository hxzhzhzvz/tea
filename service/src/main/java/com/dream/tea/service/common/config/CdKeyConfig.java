package com.dream.tea.service.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yongfa
 * 登录相关的配置参数
 */
@Data
@Component
@ConfigurationProperties(prefix = "cd-key-config")
public class CdKeyConfig {

    /**
     * 一次最多能够生成的兑换码数量
     */
    private Integer maxQuantity = 500;
}
