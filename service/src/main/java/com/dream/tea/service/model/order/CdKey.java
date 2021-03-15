package com.dream.tea.service.model.order;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class CdKey {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 业务类型，现在默认是1
     */
    private Integer bizType;

    /**
     * 兑换码的过期时间，null的时候认为永不过期
     */
    private Date expireTime;

    /**
     * 生成的兑换码数量
     */
    private Integer quantity;

    /**
     * 不同业务类型的兑换码所携带的业务信息
     */
    private String extendObj;

    /**
     * 使用状态，0表示被废弃
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