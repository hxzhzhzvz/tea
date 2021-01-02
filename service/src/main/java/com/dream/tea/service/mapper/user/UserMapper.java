package com.dream.tea.service.mapper.user;

import com.dream.tea.service.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yongfa
 */
@Mapper
public interface UserMapper {

    /**
     * 新增一个账号
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 修改用户的一些基本信息
     *
     * @param record
     * @return
     */
    int updateUserinfo(User record);

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