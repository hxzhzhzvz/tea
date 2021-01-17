package com.dream.tea.service.service.uservideo.impl;

import com.dream.tea.service.cache.lock.LockService;
import com.dream.tea.service.common.bean.ResultCodeEnum;
import com.dream.tea.service.enums.StatusEnum;
import com.dream.tea.service.mapper.user.UserVideoListMapper;
import com.dream.tea.service.model.library.VideoList;
import com.dream.tea.service.model.user.UserVideoList;
import com.dream.tea.service.service.uservideo.UserVideoService;
import com.dream.tea.service.service.video.VideoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongfa
 */
@Service
public class UserVideoServiceImpl implements UserVideoService {

    /**
     * redis业务前缀
     */
    private static final String KEY_PREFIX = "user_video:";

    @Resource
    private UserVideoListMapper userVideoListMapper;

    @Resource
    private LockService lockService;

    @Resource
    private VideoService videoService;

    @Override
    public void addVideoList(Long userId, Long videoListId) {
        String lockName = KEY_PREFIX + "addVideoList";
        String lockValue = lockService.getLock(lockName);
        if (StringUtils.isNotBlank(lockValue)) {
            try {
                VideoList videoList = videoService.getById(videoListId);
                Assert.notNull(videoList, "视频资源列表不存在");
                if (StatusEnum.ZERO.getStatus().equals(videoList.getStatus())) {
                    throw new IllegalArgumentException(ResultCodeEnum.SOURCE_NOT_VALID.getMsg());
                }
                UserVideoList record = userVideoListMapper.getByUserIdAndVideoListId(userId, videoListId);
                Assert.isNull(record, "该视频已经被收藏过了");
                record = new UserVideoList();
                record.setUserId(userId);
                record.setVideoListId(videoListId);
                userVideoListMapper.insert(record);
            } finally {
                lockService.releaseLock(lockName, lockValue);
            }
        }
    }

    @Override
    public List<VideoList> getByUserId(Long userId) {
        List<Long> videoListIdList = userVideoListMapper.getByUserId(userId);
        return videoService.getByVideoListIdList(videoListIdList);
    }
}
