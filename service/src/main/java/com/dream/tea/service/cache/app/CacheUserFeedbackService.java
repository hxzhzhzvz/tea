package com.dream.tea.service.cache.app;

/**
 * @author yongfa
 */
public interface CacheUserFeedbackService {

    /**
     * 判断用户是否可以继续提交反馈信息
     * 防止而已反馈操作
     *
     * @param userId 指定的用户id
     * @return 判断结果
     */
    boolean canSubmitFeedback(Long userId);
}
