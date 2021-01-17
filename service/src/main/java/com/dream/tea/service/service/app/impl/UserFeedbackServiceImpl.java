package com.dream.tea.service.service.app.impl;

import com.dream.tea.service.cache.app.CacheUserFeedbackService;
import com.dream.tea.service.mapper.user.UserFeedbackMapper;
import com.dream.tea.service.model.user.UserFeedback;
import com.dream.tea.service.service.app.UserFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {

    @Resource
    private UserFeedbackMapper userFeedbackMapper;

    @Resource
    private CacheUserFeedbackService cacheUserFeedbackService;

    @Override
    public void addUserFeedback(Long userId, String content) {
        boolean canSubmitFeedback = cacheUserFeedbackService.canSubmitFeedback(userId);
        if (canSubmitFeedback) {
            UserFeedback record = new UserFeedback();
            record.setUserId(userId);
            record.setContent(content);
            userFeedbackMapper.insert(record);
        }
    }
}
