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

}