package com.dream.tea.service.model.library;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class VideoList {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 视频列表的名字
     */
    private String name;

    /**
     * 视频列表的封面
     */
    private String coverUrl;

    /**
     * 当前状态，0表示下架，1表示上架
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近修改时间
     */
    private Date gmtUpdate;

}