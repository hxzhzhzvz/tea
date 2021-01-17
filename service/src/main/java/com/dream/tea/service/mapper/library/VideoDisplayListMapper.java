package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.VideoDisplayList;
import java.util.List;

public interface VideoDisplayListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VideoDisplayList record);

    VideoDisplayList selectByPrimaryKey(Long id);

    List<VideoDisplayList> selectAll();

    int updateByPrimaryKey(VideoDisplayList record);
}