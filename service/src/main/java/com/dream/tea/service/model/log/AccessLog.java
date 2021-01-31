package com.dream.tea.service.model.log;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class AccessLog {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 用户的id
     */
    private Long userId;

    /**
     * 访问的uri
     */
    private String uri;

    /**
     * 记录的插入时间
     */
    private Date gmtCreate;

    /**
     * 最近更新时间
     */
    private Date gmtUpdate;

}