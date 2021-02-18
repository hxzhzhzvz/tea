package com.dream.tea.service.service.user;

import com.dream.tea.service.model.user.User;

/**
 * @author yongfa
 */
public interface UserService {

    /**
     * 通过账号获取用户信息
     *
     * @param account 用户的账号
     * @return 用户对象
     */
    User getUserByAccount(String account);

    /**
     * 通过id获取用户信息
     *
     * @param userId 用户的id
     * @return 用户对象
     */
    User getUserById(Long userId);
}
