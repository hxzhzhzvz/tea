package com.dream.tea.service.enums;

import com.dream.tea.service.service.cdkey.exchange.CdKeyExchangeServiceTemplate;
import com.dream.tea.service.service.cdkey.exchange.MembershipPackageCdKeyExchangeTemplate;
import lombok.Getter;

/**
 * @author yongfa
 */
@Getter
public enum CdKeyExchangeTemplateEnum {

    /**
     * 会员兑换码操作
     */
    MEMBERSHIP_PACKAGE(1, MembershipPackageCdKeyExchangeTemplate.class);

    /**
     * 业务类型
     */
    private final Integer bizType;

    /**
     * 对应的策略方法
     */
    private final Class<? extends CdKeyExchangeServiceTemplate> targetInterface;

    CdKeyExchangeTemplateEnum(Integer bizType, Class<? extends CdKeyExchangeServiceTemplate> targetInterface) {
        this.bizType = bizType;
        this.targetInterface = targetInterface;
    }


    public static CdKeyExchangeTemplateEnum of(Integer bizType) {
        for (CdKeyExchangeTemplateEnum value : CdKeyExchangeTemplateEnum.values()) {
            if (value.bizType.equals(bizType)) {
                return value;
            }
        }
        return null;
    }

}
