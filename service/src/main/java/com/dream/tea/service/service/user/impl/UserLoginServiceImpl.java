package com.dream.tea.service.service.user.impl;

import cn.hutool.core.util.ObjectUtil;
import com.dream.tea.service.cache.user.CacheLoginService;
import com.dream.tea.service.common.bean.BusinessException;
import com.dream.tea.service.common.bean.ResultCodeEnum;
import com.dream.tea.service.mapper.user.UserMapper;
import com.dream.tea.service.model.user.User;
import com.dream.tea.service.service.user.UserLoginService;
import com.dream.tea.service.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private CacheLoginService cacheLoginService;

    @Override
    public User login(String account, String password) {
        if (!cacheLoginService.allowTryToLogin(account)) {
            throw new BusinessException(ResultCodeEnum.TOO_MANY_ATTEMPTS_FOR_THIS_ACCOUNT);
        }
        User user = userService.getUserByAccount(account);
        if (ObjectUtil.isNull(user)) {
            throw new BusinessException(ResultCodeEnum.ACCOUNT_NOT_EXISTS);
        }
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(ResultCodeEnum.PASSWORD_INCORRECT);
        }
        return user;
    }

    @Override
    public int register(User user) {
        User exists = userService.getUserByAccount(user.getAccount());
        if (ObjectUtil.isNotNull(exists)) {
            throw new BusinessException(ResultCodeEnum.ACCOUNT_IS_EXISTS);
        }
        return userMapper.insert(user);
    }
}
