package com.dream.tea.service.service.user;

import com.dream.tea.service.model.user.User;

/**
 * @author yongfa
 */
public interface UserService {

    /**
     * 通过账号获取用户信息
     *
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 通过id获取用户信息
     *
     * @param userId
     * @return
     */
    User getUserById(Long userId);
}
