package com.dream.tea.provider.converter.video;

import com.dream.tea.provider.vo.resp.video.VideoListRespVo;
import com.dream.tea.service.model.library.Video;
import com.dream.tea.service.model.library.VideoList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author yongfa
 */
@Mapper
public interface VideoConverter {

    VideoConverter INSTANCE = Mappers.getMapper(VideoConverter.class);

    /**
     * 将视频列表资源对象转换成对应的VO资源列表
     *
     * @param videoLists 视频资源对象列表
     * @return 转换过后的VO列表
     */
    List<VideoListRespVo> videoListToVoList(List<VideoList> videoLists);

    /**
     * 将VideoList转换成VO对象，主要是为了让上面的转换生效
     *
     * @param videoList 资源列表对象
     * @return 转换成功之后的VO
     */
    @Mapping(source = "id", target = "videoListId")
    VideoListRespVo videoListToVo(VideoList videoList);

    /**
     * 将视频列表转换成对应的VO对象列表
     *
     * @param videoList 视频对象列表
     * @return 转换过后的VO列表
     */
    List<VideoRespVo> videoToVoList(List<Video> videoList);

    /**
     * 将视频对象转换成VO对象
     *
     * @param video 视频对象
     * @return 转换成功之后的VO
     */
    @Mapping(source = "id", target = "videoId")
    VideoRespVo videoToVo(Video video);
}
