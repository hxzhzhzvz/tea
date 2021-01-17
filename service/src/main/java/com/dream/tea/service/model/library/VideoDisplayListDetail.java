package com.dream.tea.service.model.library;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class VideoDisplayListDetail {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 所属的视频展示列表的配置的id
     */
    private Long videoDisplayListId;

    /**
     * 视频列表的id
     */
    private Long videoListId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近修改的时间
     */
    private Date gmtUpdate;
}