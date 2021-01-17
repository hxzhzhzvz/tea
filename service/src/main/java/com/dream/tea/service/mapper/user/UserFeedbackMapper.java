package com.dream.tea.service.mapper.user;

import com.dream.tea.service.model.user.UserFeedback;
import org.springframework.stereotype.Repository;

/**
 * @author yongfa
 */
@Repository
public interface UserFeedbackMapper {

    /**
     * 新增用户意见反馈
     *
     * @param record 新增的记录
     * @return 成功执行的条数
     */
    int insert(UserFeedback record);

}