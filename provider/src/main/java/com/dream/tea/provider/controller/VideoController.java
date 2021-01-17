package com.dream.tea.provider.controller;

import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.converter.video.VideoConverter;
import com.dream.tea.provider.converter.video.VideoRespVo;
import com.dream.tea.provider.vo.resp.video.VideoListRespVo;
import com.dream.tea.service.model.library.Video;
import com.dream.tea.service.model.library.VideoList;
import com.dream.tea.service.service.video.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongfa
 */
@Api(tags = "video视频资源")
@RestController
@RequestMapping("/o/video")
public class VideoController {

    @Resource
    private VideoService videoService;

    @ApiOperation(value = "获取library中展示的所有资源列表", notes = "token要是存在就把token带上，后期会做相应的推荐操作")
    @GetMapping("/getVideoListForLibrary")
    public RespResult<List<VideoListRespVo>> getVideoListForLibrary() {
        List<VideoList> videoLists = videoService.getVideoListForLibrary();
        List<VideoListRespVo> videoListRespVoList = VideoConverter.INSTANCE.videoListToVoList(videoLists);
        return RespResult.succeed(videoListRespVoList);
    }

    @ApiOperation("通过视频列表id获取该列表下的所有视频")
    @GetMapping("/getByVideoListId")
    public RespResult<List<VideoRespVo>> getByVideoListId(@RequestParam("videoListId") Long videoListId) {
        List<Video> videoList = videoService.getByVideoListId(videoListId);
        List<VideoRespVo> videoRespVoList = VideoConverter.INSTANCE.videoToVoList(videoList);
        return RespResult.succeed(videoRespVoList);
    }
}
