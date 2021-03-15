package com.dream.tea.service.model.order;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class CdKeyExchange {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 兑换码定义id
     */
    private Long cdKeyId;

    /**
     * 兑换码细则id
     */
    private Long cdKeyDetailId;

    /**
     * 兑换的用户
     */
    private Long userId;

    /**
     * 兑换时间
     */
    private Date gmtCreate;

    /**
     * 最近的更新时间
     */
    private Date gmtUpdate;

}