package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.VideoDisplayListDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface VideoDisplayListDetailMapper {

    /**
     * 通过视展示列表配置id获取视频列表配置
     *
     * @param videoDisplayListId
     * @return
     */
    List<VideoDisplayListDetail> getByVideoDisplayListId(@Param("videoDisplayListId") Long videoDisplayListId);

    /**
     * 通过视频配置展示id获取到该展示将会展示的视频列表id
     *
     * @param videoDisplayListId 展示列表的配置id
     * @return 该配置所包含的视频列表id
     */
    List<Long> getVideoListIdByVideoDisplayListId(@Param("videoDisplayListId") Long videoDisplayListId);
}