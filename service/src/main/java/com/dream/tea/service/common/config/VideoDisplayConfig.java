package com.dream.tea.service.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yongfa
 * 前端展示的视频列表
 */
@Data
@Component
@ConfigurationProperties(prefix = "video-display-config")
public class VideoDisplayConfig {

    /**
     * 视频列表配置id
     */
    private Long videoDisplayListId = 1L;
}
