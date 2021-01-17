package com.dream.tea.service.service.video;

import com.dream.tea.service.model.library.Video;
import com.dream.tea.service.model.library.VideoList;

import java.util.List;

/**
 * @author yongfa
 */
public interface VideoService {

    /**
     * 获取公共资源中展示的视频列表
     *
     * @return 返回视频列表的列表
     */
    List<VideoList> getVideoListForLibrary();

    /**
     * 通过视频列表id获取该列表下的所有视频
     *
     * @param videoListId 视频列表id
     * @return 返回视频列表
     */
    List<Video> getByVideoListId(Long videoListId);

    /**
     * 通过id获取到视频列表定义
     *
     * @param id 视频列表的id
     * @return 查询结果
     */
    VideoList getById(Long id);

    /**
     * 通过id列表获取到对应的视频资源列表集合
     *
     * @param videoListIdList 指定的视频资源列表id
     * @return 资源列表集合
     */
    List<VideoList> getByVideoListIdList(List<Long> videoListIdList);
}
