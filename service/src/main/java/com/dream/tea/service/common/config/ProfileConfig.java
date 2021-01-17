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
@ConfigurationProperties(prefix = "profile-config")
public class ProfileConfig {

    /**
     * 在允许的范围内最多尝试次数
     */
    private Integer loginMaxTryTimes = 100;

    /**
     * 计数的时间范围，单位是分钟
     */
    private Integer loginCollectLimitRange = 10;

}
