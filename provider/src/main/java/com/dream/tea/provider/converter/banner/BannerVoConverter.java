package com.dream.tea.provider.converter.banner;

import com.dream.tea.provider.vo.resp.banner.BannerRespVo;
import com.dream.tea.service.model.config.Banner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author yongfa
 */
@Mapper
public interface BannerVoConverter {

    BannerVoConverter INSTANCE = Mappers.getMapper(BannerVoConverter.class);

    /**
     * 将banner列表转成banner的vo列表
     *
     * @param bannerList 对象列表
     * @return 转换后的vo列表
     */
    List<BannerRespVo> bannerListToBannerVoList(List<Banner> bannerList);
}
