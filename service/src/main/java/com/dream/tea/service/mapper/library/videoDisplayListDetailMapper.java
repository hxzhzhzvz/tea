package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.videoDisplayListDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface videoDisplayListDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(videoDisplayListDetail record);

    videoDisplayListDetail selectByPrimaryKey(Long id);

    List<videoDisplayListDetail> selectAll();

    int updateByPrimaryKey(videoDisplayListDetail record);
}