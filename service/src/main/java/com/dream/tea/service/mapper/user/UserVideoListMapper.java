package com.dream.tea.service.mapper.user;

import com.dream.tea.service.model.user.UserVideoList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface UserVideoListMapper {

    /**
     * 新增收藏记录
     *
     * @param record 记录对象
     * @return 新增结果
     */
    int insert(UserVideoList record);

    /**
     * 通过用户id和视频列表id去获取用户表的收藏记录
     *
     * @param userId      指定的用户id
     * @param videoListId 视频资源列表id
     * @return 查询结果
     */
    UserVideoList getByUserIdAndVideoListId(@Param("userId") Long userId, @Param("videoListId") Long videoListId);

    /**
     * 通过用户id获取到这个用户所收藏的所有视频资源列表
     *
     * @param userId 指定的用户id
     * @return 收藏的资源id列表
     */
    List<Long> getByUserId(@Param("userId") Long userId);

}