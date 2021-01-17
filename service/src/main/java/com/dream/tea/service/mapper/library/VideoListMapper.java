package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.VideoList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface VideoListMapper {

    /**
     * 查询视频播放列表
     *
     * @param idList 列表id
     * @param status 当前状态，0表示禁用，1表示上架
     * @return
     */
    List<VideoList> getByIdListAndStatus(@Param("idList") List<Long> idList, @Param("status") Integer status);

    /**
     * 通过id获取到视频列表定义
     *
     * @param id 视频列表的id
     * @return 查询结果
     */
    VideoList getById(@Param("id") Long id);

    /**
     * 通过id列表获取到对应的视频资源列表集合
     *
     * @param videoListIdList 指定的视频资源列表id
     * @return 资源列表集合
     */
    List<VideoList> getByVideoListIdList(@Param("videoListIdList") List<Long> videoListIdList);
}