package com.dream.tea.service.service.cdkey.exchange.impl;

import cn.hutool.core.lang.Assert;
import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import com.dream.tea.service.service.cdkey.CdKeyService;
import com.dream.tea.service.service.cdkey.exchange.MembershipPackageCdKeyExchangeTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class MembershipPackageCdKeyExchangeTemplateImpl extends MembershipPackageCdKeyExchangeTemplate {

    @Resource
    private CdKeyService cdKeyService;

    @Override
    protected MembershipPackageExtendObj checkAndReturnExtendObj(BatchCreateCdKeyReqDto reqDto) {
        MembershipPackageExtendObj extendObj = new MembershipPackageExtendObj();
        Object membershipPackageIdObj = reqDto.getExtendInfo().get("membershipPackageId");
        Assert.notNull(membershipPackageIdObj, "会员套餐id的没有指定取值");
        Long membershipPackageId = Long.valueOf(membershipPackageIdObj.toString());
        extendObj.setMembershipPackageId(membershipPackageId);
        return extendObj;
    }

    @Override
    protected BatchCreateCdKeyRespDto doCreateCdKey(BatchCreateCdKeyReqDto reqDto) {
        // 正常情况下这里是有校验逻辑的
        return cdKeyService.doCreateCdKey(reqDto);
    }

}
