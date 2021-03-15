package com.dream.tea.provider.converter.single;

import com.dream.tea.provider.vo.req.single.GetSingleVideoListByPageReqVo;
import com.dream.tea.provider.vo.resp.single.GetSingleVideoListByPageRespVo;
import com.dream.tea.provider.vo.resp.single.SingleVideoVo;
import com.dream.tea.service.dto.req.single.GetSingleVideoListByPageReqDto;
import com.dream.tea.service.dto.resp.single.GetSingleVideoListByPageRespDto;
import com.dream.tea.service.model.library.SingleVideo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author LiYongFa
 */
@Mapper
public interface SingleVideoConverter {

    SingleVideoConverter INSTANCE = Mappers.getMapper(SingleVideoConverter.class);

    /**
     * 将GetSingleVideoListByPageReqVo对象转换成GetSingleVideoListByPageReqDto对象
     *
     * @param reqVo 请求的VO对象
     * @return 转换结果
     */
    GetSingleVideoListByPageReqDto getSingleVideoListByPageReqVoToDto(GetSingleVideoListByPageReqVo reqVo);

    /**
     * 将SingleVideo对象转换成SingleVideoVo对象
     *
     * @param singleVideo 数据库实体
     * @return 转换结果
     */
    @Mapping(target = "singleVideoId", source = "id")
    SingleVideoVo singleVideoToVo(SingleVideo singleVideo);

    /**
     * 将GetSingleVideoListByPageRespDto对象转换成GetSingleVideoListByPageRespVo对象
     *
     * @param respDto DTO对象
     * @return 转换之后的VO对象
     */
    GetSingleVideoListByPageRespVo getSingleVideoListByPageRespDtoToVo(GetSingleVideoListByPageRespDto respDto);
}
