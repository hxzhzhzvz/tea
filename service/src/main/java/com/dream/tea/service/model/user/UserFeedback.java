package com.dream.tea.service.model.user;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class UserFeedback {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 用户的id
     */
    private Long userId;

    /**
     * 反馈的内容他
     */
    private String content;

    /**
     * 记录的生成时间
     */
    private Date gmtCreate;

    /**
     * 记录的最近更新时间
     */
    private Date gmtUpdate;

}