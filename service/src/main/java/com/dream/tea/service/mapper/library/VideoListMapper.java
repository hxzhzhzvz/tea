package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.VideoList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface VideoListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VideoList record);

    VideoList selectByPrimaryKey(Long id);

    List<VideoList> selectAll();

    int updateByPrimaryKey(VideoList record);
}