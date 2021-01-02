package com.dream.tea.provider.common.login.utils;

import com.dream.tea.provider.common.login.TokenUserHelper;
import com.dream.tea.provider.common.login.entity.JwtPayload;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    /**
     * 获取当前用户的userId
     *
     * @return
     */
    public static Long getUserId() {
        return TokenUserHelper.getCurrUser().getUserId();
    }

    /**
     * 获取当前用户的手机号码
     *
     * @return
     */
    public static String getPhone() {
        return TokenUserHelper.getCurrUser().getPhone();
    }

    /**
     * 获取当前用户
     *
     * @return
     */
    public static JwtPayload getCurrentUser() {
        return TokenUserHelper.getCurrUser();
    }
}
