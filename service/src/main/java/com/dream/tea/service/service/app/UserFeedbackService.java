package com.dream.tea.service.service.app;

/**
 * @author yongfa
 */
public interface UserFeedbackService {

    /**
     * 新增用户反馈记录
     *
     * @param userId  反馈的用户id
     * @param content 返回的内容
     */
    void addUserFeedback(Long userId, String content);
}
