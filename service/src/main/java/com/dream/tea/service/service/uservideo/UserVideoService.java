package com.dream.tea.service.service.uservideo;

import com.dream.tea.service.model.library.VideoList;

import java.util.List;

/**
 * @author yongfa
 */
public interface UserVideoService {

    /**
     * 用户新增视频收藏记录
     *
     * @param userId      指定的用户
     * @param videoListId 指定的视频列表
     */
    void addVideoList(Long userId, Long videoListId);

    /**
     * 获取指定用户的所有收藏列表
     *
     * @param userId 指定的用户id
     * @return 视频列表
     */
    List<VideoList> getByUserId(Long userId);
}
