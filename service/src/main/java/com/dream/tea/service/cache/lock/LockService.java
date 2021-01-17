package com.dream.tea.service.cache.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author yongfa
 */
public interface LockService {

    /**
     * 获取锁
     *
     * @param lockName   锁的名字
     * @param expireTime ttl的时间
     * @param timeUnit   ttl的单位
     * @return 锁的值
     */
    String getLock(String lockName, long expireTime, TimeUnit timeUnit);

    /**
     * 获取锁
     * 锁持续的时间是10s
     *
     * @param lockName 锁的名字
     * @return 锁的值
     */
    String getLock(String lockName);

    /**
     * 释放锁
     *
     * @param lockName  锁的名字
     * @param lockValue 锁的值
     */
    void releaseLock(String lockName, String lockValue);
}
