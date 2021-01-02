package com.dream.tea.service.service.user;

import com.dream.tea.service.model.user.User;

/**
 * @author yongfa
 */
public interface UserLoginService {

    /**
     * 登录操作
     *
     * @param account
     * @param password
     * @return
     */
    User login(String account, String password);

    /**
     * 注册一个新账号
     *
     * @param user
     * @return
     */
    int register(User user);
}
