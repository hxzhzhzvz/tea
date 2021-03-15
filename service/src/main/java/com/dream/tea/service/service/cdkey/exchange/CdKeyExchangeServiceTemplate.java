package com.dream.tea.service.service.cdkey.exchange;

import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yongfa
 * 兑换码兑换业务
 */
@Slf4j
public abstract class CdKeyExchangeServiceTemplate {

    public BatchCreateCdKeyRespDto batchCreateCdKey(BatchCreateCdKeyReqDto reqDto) {
        BatchCreateCdKeyRespDto respDto = null;
        try {
            Object extendObj = checkAndReturnExtendObj(reqDto);
            reqDto.setExtendObj(extendObj);
            preHandler(reqDto);
            respDto = doCreateCdKey(reqDto);
            afterComplete(reqDto, respDto);
        } catch (Throwable throwable) {
            afterException(reqDto, throwable);
        }
        return respDto;
    }


    /**
     * 校验批量创建兑换码中的扩展信息是否合法，并返回对应的bean扩展对象
     *
     * @param reqDto 参数对象
     * @return 扩展对象
     */
    protected abstract Object checkAndReturnExtendObj(BatchCreateCdKeyReqDto reqDto);

    /**
     * 前置校验操作
     *
     * @param reqDto 创建参数
     */
    protected void preHandler(BatchCreateCdKeyReqDto reqDto) {
        // do nothing
    }


    /**
     * 兑换码的兑换处理操作
     *
     * @param reqDto 创建参数
     * @return 创建结果
     */
    protected abstract BatchCreateCdKeyRespDto doCreateCdKey(BatchCreateCdKeyReqDto reqDto);

    /**
     * 处理成功之后的调用结果
     *
     * @param reqDto  请求对象
     * @param respDto 处理结果
     */
    protected void afterComplete(BatchCreateCdKeyReqDto reqDto, BatchCreateCdKeyRespDto respDto) {
        // do nothing
    }

    /**
     * 异常情况下的后置处理防范
     *
     * @param reqDto    请求参数
     * @param throwable 异常对象
     */
    protected void afterException(BatchCreateCdKeyReqDto reqDto, Throwable throwable) {
        // do nothing
        log.error("创建兑换码失败", throwable);
        throw new RuntimeException(throwable.getCause());
    }
}
