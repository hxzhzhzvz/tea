package com.dream.tea.service.model.config;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class Developer {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 开发者说明
     */
    private String content;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近更新时间
     */
    private Date gmtUpdate;

}