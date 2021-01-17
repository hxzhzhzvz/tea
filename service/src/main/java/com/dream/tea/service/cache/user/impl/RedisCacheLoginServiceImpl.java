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
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(key, profileConfig.getLoginMaxTryTimes().toString(), profileConfig.getLoginCollectLimitRange(), TimeUnit.MINUTES);
        if (ObjectUtil.isNotNull(result) && result) {
            return true;
        } else {
            Boolean keyExists = stringRedisTemplate.hasKey(key);
            if (ObjectUtil.isNotNull(keyExists) && keyExists) {
                // 防止出现key不会过期的情况
                Long decrResult = stringRedisTemplate.opsForValue().decrement(key);
                return ObjectUtil.isNotNull(decrResult) && (decrResult >= 0);
            } else {
                return false;
            }
        }
    }
}
