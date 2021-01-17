package com.dream.tea.provider.common.login.utils;

import com.dream.tea.provider.common.login.TokenUserHelper;
import com.dream.tea.provider.common.login.entity.JwtPayload;
import org.springframework.stereotype.Component;

/**
 * @author yongfa
 */
@Component
public class UserUtils {

    /**
     * 获取当前用户的userId
     *
     * @return 用户的id
     */
    public static Long getUserId() {
        return TokenUserHelper.getCurrUser().getUserId();
    }

    /**
     * 获取当前用户
     *
     * @return 用户的信息的载荷
     */
    public static JwtPayload getCurrentUser() {
        return TokenUserHelper.getCurrUser();
    }
}
