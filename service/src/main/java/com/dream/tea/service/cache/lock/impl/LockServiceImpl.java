package com.dream.tea.service.cache.lock.impl;

import cn.hutool.core.util.ObjectUtil;
import com.dream.tea.service.cache.lock.LockService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yongfa
 */
@Service
public class LockServiceImpl implements LockService {

    /**
     * 锁缓存的前缀
     */
    private static final String KEY_PREFIX = "lock:";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getLock(String lockName, long expireTime, TimeUnit timeUnit) {
        String lockKey = KEY_PREFIX + lockName;
        String lockValue = RandomStringUtils.random(10);
        Boolean lockRes = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, lockValue, expireTime, timeUnit);
        if (ObjectUtil.isNotNull(lockRes) && lockRes) {
            return lockValue;
        }
        return null;
    }

    @Override
    public String getLock(String lockName) {
        return getLock(lockName, 10, TimeUnit.SECONDS);
    }

    @Override
    public void releaseLock(String lockName, String lockValue) {
        String lockKey = KEY_PREFIX + lockName;
        String lockValue1 = stringRedisTemplate.opsForValue().get(lockKey);
        if (lockValue.equals(lockValue1)) {
            stringRedisTemplate.delete(lockKey);
        }
    }
}
