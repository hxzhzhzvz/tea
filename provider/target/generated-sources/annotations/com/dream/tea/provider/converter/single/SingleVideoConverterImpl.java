package com.dream.tea.provider.converter.single;

import com.dream.tea.provider.vo.req.single.GetSingleVideoListByPageReqVo;
import com.dream.tea.provider.vo.resp.single.GetSingleVideoListByPageRespVo;
import com.dream.tea.provider.vo.resp.single.SingleVideoVo;
import com.dream.tea.service.dto.req.single.GetSingleVideoListByPageReqDto;
import com.dream.tea.service.dto.resp.single.GetSingleVideoListByPageRespDto;
import com.dream.tea.service.model.library.SingleVideo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-14T16:18:36+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class SingleVideoConverterImpl implements SingleVideoConverter {

    @Override
    public GetSingleVideoListByPageReqDto getSingleVideoListByPageReqVoToDto(GetSingleVideoListByPageReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        GetSingleVideoListByPageReqDto getSingleVideoListByPageReqDto = new GetSingleVideoListByPageReqDto();

        getSingleVideoListByPageReqDto.setLimitSize( reqVo.getLimitSize() );
        getSingleVideoListByPageReqDto.setMaxId( reqVo.getMaxId() );

        return getSingleVideoListByPageReqDto;
    }

    @Override
    public SingleVideoVo singleVideoToVo(SingleVideo singleVideo) {
        if ( singleVideo == null ) {
            return null;
        }

        SingleVideoVo singleVideoVo = new SingleVideoVo();

        singleVideoVo.setSingleVideoId( singleVideo.getId() );
        singleVideoVo.setName( singleVideo.getName() );
        singleVideoVo.setCoverUrl( singleVideo.getCoverUrl() );
        singleVideoVo.setVideoUrl( singleVideo.getVideoUrl() );

        return singleVideoVo;
    }

    @Override
    public GetSingleVideoListByPageRespVo getSingleVideoListByPageRespDtoToVo(GetSingleVideoListByPageRespDto respDto) {
        if ( respDto == null ) {
            return null;
        }

        GetSingleVideoListByPageRespVo getSingleVideoListByPageRespVo = new GetSingleVideoListByPageRespVo();

        getSingleVideoListByPageRespVo.setMaxId( respDto.getMaxId() );
        getSingleVideoListByPageRespVo.setHasNextPage( respDto.getHasNextPage() );
        getSingleVideoListByPageRespVo.setDataList( singleVideoListToSingleVideoVoList( respDto.getDataList() ) );

        return getSingleVideoListByPageRespVo;
    }

    protected List<SingleVideoVo> singleVideoListToSingleVideoVoList(List<SingleVideo> list) {
        if ( list == null ) {
            return null;
        }

        List<SingleVideoVo> list1 = new ArrayList<SingleVideoVo>( list.size() );
        for ( SingleVideo singleVideo : list ) {
            list1.add( singleVideoToVo( singleVideo ) );
        }

        return list1;
    }
}
