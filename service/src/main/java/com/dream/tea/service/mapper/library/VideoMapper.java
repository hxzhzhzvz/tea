package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface VideoMapper {

    /**
     * 通过视频列表id获取该列表下的所有视频
     *
     * @param videoListId 视频列表id
     * @return
     */
    List<Video> getByVideoListId(@Param("videoListId") Long videoListId);
}