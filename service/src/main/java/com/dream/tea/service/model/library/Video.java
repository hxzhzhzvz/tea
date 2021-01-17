package com.dream.tea.service.model.library;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class Video {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 该视频所属的视频列表的id
     */
    private Long videoListId;

    /**
     * 视频的名字
     */
    private String name;

    /**
     * 视频的封面
     */
    private String coverUrl;

    /**
     * 视频链接
     */
    private String videoUrl;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近的更新时间
     */
    private Date gmtUpdate;
}