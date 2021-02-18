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
     * @param record 用户对象
     * @return 插入结果
     */
    int insert(User record);

    /**
     * 通过账号获取用户信息
     *
     * @param account 用户账号
     * @return 用户对象
     */
    User getByAccount(@Param("account") String account);

    /**
     * 通过id获取用户的信息
     *
     * @param userId 用户的id
     * @return 用户对象
     */
    User getByUserId(@Param("userId") Long userId);
}