package com.dream.tea.service.cache.app.impl;

import cn.hutool.core.util.ObjectUtil;
import com.dream.tea.service.cache.app.CacheUserFeedbackService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author yongfa
 */
@Service
public class RedisCacheUserFeedbackServiceImpl implements CacheUserFeedbackService {

    /**
     * key的业务前缀
     */
    private static final String KEY_PREFIX = "feedback:";

    /**
     * 同一个用户每天最多能够提交的反馈意见数量
     */
    private static final int THRESHOLD = 20;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean canSubmitFeedback(Long userId) {
        String key = KEY_PREFIX + userId;
        Boolean setRes = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 1, TimeUnit.DAYS);
        if (ObjectUtil.isNotNull(setRes)) {
            if (setRes) {
                return true;
            } else {
                Long incrRes = stringRedisTemplate.opsForValue().increment(key);
                return ObjectUtil.isNull(incrRes) || (incrRes <= THRESHOLD);
            }
        }
        return true;
    }
}
