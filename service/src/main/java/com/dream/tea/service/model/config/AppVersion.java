package com.dream.tea.service.model.config;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class AppVersion {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 更新title
     */
    private String title;

    /**
     * 更新的内容
     */
    private String content;

    /**
     * 版本号
     */
    private String version;

    /**
     * 下载链接
     */
    private String url;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最新更新时间
     */
    private Date gmtUpdate;
}