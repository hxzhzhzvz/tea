package com.dream.tea.provider.controller;

import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.common.login.annotation.LoginRequired;
import com.dream.tea.provider.common.login.utils.UserUtils;
import com.dream.tea.provider.converter.video.VideoConverter;
import com.dream.tea.provider.vo.req.uservideo.AddVideoListReqVo;
import com.dream.tea.provider.vo.resp.video.VideoListRespVo;
import com.dream.tea.service.model.library.VideoList;
import com.dream.tea.service.service.uservideo.UserVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author yongfa
 */
@Api(tags = "userVideo用户收藏的视频资源")
@RestController
@RequestMapping("/o/userVideo")
public class UserVideoController {

    @Resource
    private UserVideoService userVideoService;

    @LoginRequired
    @ApiOperation("收藏视频列表")
    @PostMapping("/addVideoList")
    public RespResult<Void> addVideoList(@RequestBody @Valid AddVideoListReqVo reqVo) {
        try {
            Long userId = UserUtils.getUserId();
            userVideoService.addVideoList(userId, reqVo.getVideoListId());
            return RespResult.succeed();
        } catch (IllegalArgumentException e) {
            return RespResult.failed(e.getMessage());
        }
    }

    @LoginRequired
    @ApiOperation("获取到用户的所有收藏的视频列表")
    @GetMapping("/getVideoListForDesk")
    public RespResult<List<VideoListRespVo>> getVideoListForDesk() {
        Long userId = UserUtils.getUserId();
        List<VideoList> videoLists = userVideoService.getByUserId(userId);
        List<VideoListRespVo> videoListRespVoList = VideoConverter.INSTANCE.videoListToVoList(videoLists);
        return RespResult.succeed(videoListRespVoList);
    }
}
