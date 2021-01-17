package com.dream.tea.service.model.config;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class Banner {

    /**
     * 自增id
     */
    private Long id;

    /**
     * banner的title
     */
    private String title;

    /**
     * banner的封面
     */
    private String coverUrl;

    /**
     * 跳转链接，可为空
     */
    private String linkUrl;

    /**
     * 生效状态，1表示生效，0表示下架
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;
}