package com.dream.tea.service.service.user.impl;

import com.dream.tea.service.mapper.user.UserMapper;
import com.dream.tea.service.model.user.User;
import com.dream.tea.service.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getByAccount(account);
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getByUserId(userId);
    }
}
