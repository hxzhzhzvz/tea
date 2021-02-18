package com.dream.tea.service.service.user;

import com.dream.tea.service.model.user.User;

/**
 * @author yongfa
 */
public interface UserLoginService {

    /**
     * 登录操作
     *
     * @param account  账号
     * @param password 密码
     * @return 用户对象
     */
    User login(String account, String password);

    /**
     * 注册一个新账号
     *
     * @param user 用户对象
     */
    void register(User user);
}
