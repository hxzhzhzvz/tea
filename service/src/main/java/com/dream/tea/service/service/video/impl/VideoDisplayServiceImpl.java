package com.dream.tea.service.service.video.impl;

import cn.hutool.core.collection.CollUtil;
import com.dream.tea.service.common.config.VideoDisplayConfig;
import com.dream.tea.service.enums.StatusEnum;
import com.dream.tea.service.mapper.library.VideoDisplayListDetailMapper;
import com.dream.tea.service.mapper.library.VideoListMapper;
import com.dream.tea.service.mapper.library.VideoMapper;
import com.dream.tea.service.model.library.Video;
import com.dream.tea.service.model.library.VideoList;
import com.dream.tea.service.service.video.VideoDisplayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author yongfa
 */
@Service
public class VideoDisplayServiceImpl implements VideoDisplayService {

    @Resource
    private VideoDisplayConfig videoDisplayConfig;

    @Resource
    private VideoDisplayListDetailMapper videoDisplayListDetailMapper;

    @Resource
    private VideoListMapper videoListMapper;

    @Resource
    private VideoMapper videoMapper;

    @Override
    public List<VideoList> getVideoListForLibrary() {
        List<Long> videoListIdList = videoDisplayListDetailMapper.getVideoListIdByVideoDisplayListId(videoDisplayConfig.getVideoDisplayListId());
        if (CollUtil.isEmpty(videoListIdList)) {
            return Collections.emptyList();
        }
        return videoListMapper.getByIdListAndStatus(videoListIdList, StatusEnum.ONE.getStatus());
    }

    @Override
    public List<Video> getByVideoListId(Long videoListId) {
        return videoMapper.getByVideoListId(videoListId);
    }
}
