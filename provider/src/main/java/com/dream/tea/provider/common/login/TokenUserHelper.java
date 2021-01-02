package com.dream.tea.provider.common.login;

import com.dream.tea.provider.common.login.entity.JwtPayload;

/**
 * @author yongfa
 */
public class TokenUserHelper {

    private static final ThreadLocal<JwtPayload> USER_HOLDER = new ThreadLocal<>();

    /**
     * 设置当前用户
     *
     * @param jwtPayload
     */
    public static void setCurrUser(JwtPayload jwtPayload) {
        USER_HOLDER.set(jwtPayload);
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    public static JwtPayload getCurrUser() {
        return USER_HOLDER.get();
    }

    /**
     * 移除当前缓存
     */
    public static void clear() {
        USER_HOLDER.remove();
    }
}

