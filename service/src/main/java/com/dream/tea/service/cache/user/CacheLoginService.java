package com.dream.tea.service.cache.user;

/**
 * @author yongfa
 */
public interface CacheLoginService {

    /**
     * 是否允许该账号继续尝试登录
     *
     * @param account
     * @return
     */
    boolean allowTryToLogin(String account);
}

