package com.dream.tea.service.service.cdkey.impl;

import com.dream.tea.service.common.config.CdKeyConfig;
import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import com.dream.tea.service.enums.CdKeyExchangeTemplateEnum;
import com.dream.tea.service.service.cdkey.CdKeyManagerService;
import com.dream.tea.service.service.cdkey.exchange.CdKeyExchangeServiceTemplate;
import com.dream.tea.service.utils.SpringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class CdKeyManagerServiceImpl implements CdKeyManagerService {

    @Resource
    private CdKeyConfig cdKeyConfig;

    @Resource
    private SpringUtils springUtils;

    @Override
    public BatchCreateCdKeyRespDto batchCreateCdKey(BatchCreateCdKeyReqDto reqDto) {
        if (cdKeyConfig.getMaxQuantity() < reqDto.getQuantity()) {
            throw new IllegalArgumentException(String.format("一次性创建的兑换码数量不能超过%s个", cdKeyConfig.getMaxQuantity()));
        }
        CdKeyExchangeTemplateEnum cdKeyExchangeTemplateEnum = CdKeyExchangeTemplateEnum.of(reqDto.getBizType());
        Assert.notNull(cdKeyExchangeTemplateEnum, "这种业务类型的兑换码操作还未实现，请联系开发进行核实！");
        CdKeyExchangeServiceTemplate cdKeyExchangeServiceTemplate = springUtils.getBean(cdKeyExchangeTemplateEnum.getTargetInterface());
        BatchCreateCdKeyRespDto respDto = cdKeyExchangeServiceTemplate.batchCreateCdKey(reqDto);
        Assert.notNull(respDto, "创建兑换码失败");
        return respDto;
    }
}
