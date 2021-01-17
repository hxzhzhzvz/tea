package com.dream.tea.service.cache.user.impl;

import cn.hutool.core.util.ObjectUtil;
import com.dream.tea.service.cache.user.CacheLoginService;
import com.dream.tea.service.common.config.ProfileConfig;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yongfa
 */
@Service
public class RedisCacheLoginServiceImpl implements CacheLoginService {

    /**
     * redis key前缀
     */
    private static final String REDIS_KEY_PREFIX = "login:";

    @Resource
    private ProfileConfig profileConfig;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean allowTryToLogin(String account) {
        String key = REDIS_KEY_PREFIX + "allowTryToLogin:" + account;
        Boolean setRes = stringRedisTemplate.opsForValue().setIfAbsent(key, "1"
                , profileConfig.getLoginCollectLimitRange(), TimeUnit.MINUTES);
        if (ObjectUtil.isNotNull(setRes)) {
            if (setRes) {
                return true;
            } else {
                Long incrRes = stringRedisTemplate.opsForValue().increment(key);
                return ObjectUtil.isNotNull(incrRes) && (incrRes <= profileConfig.getLoginMaxTryTimes());
            }
        }
        return false;
    }
}
