package com.dream.tea.service.service.cdkey.exchange;

import lombok.Data;

/**
 * @author yongfa
 * 会员套餐兑换码兑换处理业务类
 */
public abstract class MembershipPackageCdKeyExchangeTemplate extends CdKeyExchangeServiceTemplate {

    @Data
    public static class MembershipPackageExtendObj {

        /**
         * 绑定的会员套餐id
         */
        private Long membershipPackageId;

    }

}
