package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.VideoDisplayList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface VideoDisplayListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VideoDisplayList record);

    VideoDisplayList selectByPrimaryKey(Long id);

    List<VideoDisplayList> selectAll();

    int updateByPrimaryKey(VideoDisplayList record);
}