package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface VideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Video record);

    Video selectByPrimaryKey(Long id);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}