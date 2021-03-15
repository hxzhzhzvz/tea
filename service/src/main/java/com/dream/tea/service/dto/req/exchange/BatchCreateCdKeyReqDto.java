package com.dream.tea.service.dto.req.exchange;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author yongfa
 * 所有的数据一起给到，后面再进行业务的分流操作
 */
@Data
public class BatchCreateCdKeyReqDto {

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
     * 额外信息
     */
    private Map<String, Object> extendInfo;

    /**
     * 扩展对象信息
     */
    private Object extendObj;
}
