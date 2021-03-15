package com.dream.tea.service.model.library;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class SingleVideo {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 视频的名字
     */
    private String name;

    /**
     * 封面
     */
    private String coverUrl;

    /**
     * 视频链接
     */
    private String videoUrl;

    /**
     * 视频的创建时间
     */
    private Date gmtCreate;

    /**
     * 视频的最近更新时间
     */
    private Date gmtUpdate;
}