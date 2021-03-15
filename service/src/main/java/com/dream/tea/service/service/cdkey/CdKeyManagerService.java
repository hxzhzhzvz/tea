package com.dream.tea.service.service.cdkey;

import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;

/**
 * @author yongfa
 * 兑换管理平台，生成兑换码这些
 */
public interface CdKeyManagerService {

    /**
     * 批量创建兑换码
     *
     * @param reqDto 创建参数
     * @return 兑换链接及兑换码
     */
    BatchCreateCdKeyRespDto batchCreateCdKey(BatchCreateCdKeyReqDto reqDto);
}
