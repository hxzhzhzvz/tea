package com.dream.tea.service.model.order;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class CdKeyDetail {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 兑换码定义的id
     */
    private Long cdKeyId;

    /**
     * 具体的兑换码
     */
    private String code;

    /**
     * 兑换状态,0表示未兑换，1表示已经兑换
     */
    private Integer exchangeStatus;

    /**
     * 使用状态，0表示废弃，1表示可用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最近更新时间
     */
    private Date gmtUpdate;

}