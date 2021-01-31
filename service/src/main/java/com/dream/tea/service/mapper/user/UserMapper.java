package com.dream.tea.service.mapper.user;

import com.dream.tea.service.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yongfa
 */
@Repository
public interface UserMapper {

    /**
     * 新增一个账号
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 通过账号获取用户信息
     *
     * @param account
     * @return
     */
    User getByAccount(@Param("account") String account);

    /**
     * 通过id获取用户的信息
     *
     * @param userId
     * @return
     */
    User getByUserId(@Param("userId") Long userId);
}