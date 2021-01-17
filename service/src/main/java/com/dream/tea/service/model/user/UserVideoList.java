package com.dream.tea.service.model.user;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class UserVideoList {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 用户的id
     */
    private Long userId;

    /**
     * 视频资源列表id
     */
    private Long videoListId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近更新时间
     */
    private Date gmtUpdate;

}