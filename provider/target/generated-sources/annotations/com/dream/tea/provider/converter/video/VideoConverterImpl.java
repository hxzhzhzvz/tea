package com.dream.tea.provider.converter.video;

import com.dream.tea.provider.vo.resp.video.VideoListRespVo;
import com.dream.tea.provider.vo.resp.video.VideoRespVo;
import com.dream.tea.service.model.library.Video;
import com.dream.tea.service.model.library.VideoList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-31T21:40:58+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class VideoConverterImpl implements VideoConverter {

    @Override
    public List<VideoListRespVo> videoListToVoList(List<VideoList> videoLists) {
        if ( videoLists == null ) {
            return null;
        }

        List<VideoListRespVo> list = new ArrayList<VideoListRespVo>( videoLists.size() );
        for ( VideoList videoList : videoLists ) {
            list.add( videoListToVo( videoList ) );
        }

        return list;
    }

    @Override
    public VideoListRespVo videoListToVo(VideoList videoList) {
        if ( videoList == null ) {
            return null;
        }

        VideoListRespVo videoListRespVo = new VideoListRespVo();

        videoListRespVo.setVideoListId( videoList.getId() );
        videoListRespVo.setName( videoList.getName() );
        videoListRespVo.setCoverUrl( videoList.getCoverUrl() );

        return videoListRespVo;
    }

    @Override
    public List<VideoRespVo> videoToVoList(List<Video> videoList) {
        if ( videoList == null ) {
            return null;
        }

        List<VideoRespVo> list = new ArrayList<VideoRespVo>( videoList.size() );
        for ( Video video : videoList ) {
            list.add( videoToVo( video ) );
        }

        return list;
    }

    @Override
    public VideoRespVo videoToVo(Video video) {
        if ( video == null ) {
            return null;
        }

        VideoRespVo videoRespVo = new VideoRespVo();

        videoRespVo.setVideoId( video.getId() );
        videoRespVo.setVideoListId( video.getVideoListId() );
        videoRespVo.setName( video.getName() );
        videoRespVo.setCoverUrl( video.getCoverUrl() );
        videoRespVo.setVideoUrl( video.getVideoUrl() );

        return videoRespVo;
    }
}
