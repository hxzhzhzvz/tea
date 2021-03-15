package com.dream.tea.service.service.cdkey;

import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;

/**
 * @author yongfa
 * 兑换业务实现逻辑
 */
public interface CdKeyService {

    /**
     * 进行二维码的创建操作
     *
     * @param reqDto 创建参数
     * @return 创建结果
     */
    BatchCreateCdKeyRespDto doCreateCdKey(BatchCreateCdKeyReqDto reqDto);
}
