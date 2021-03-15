package com.dream.tea.service.dto.resp.exchange;

import lombok.Data;

import java.util.List;

/**
 * @author yongfa
 */
@Data
public class BatchCreateCdKeyRespDto {

    /**
     * 兑换链接
     */
    private String exchangeUrl = "";

    /**
     * 兑换码列表
     */
    private List<String> cdCodeList;
}
