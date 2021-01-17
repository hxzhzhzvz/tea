package com.dream.tea.provider.converter.banner;

import com.dream.tea.provider.vo.resp.banner.BannerRespVo;
import com.dream.tea.service.model.config.Banner;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T17:08:11+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class BannerVoConverterImpl implements BannerVoConverter {

    @Override
    public List<BannerRespVo> bannerListToBannerVoList(List<Banner> bannerList) {
        if ( bannerList == null ) {
            return null;
        }

        List<BannerRespVo> list = new ArrayList<BannerRespVo>( bannerList.size() );
        for ( Banner banner : bannerList ) {
            list.add( bannerToBannerRespVo( banner ) );
        }

        return list;
    }

    protected BannerRespVo bannerToBannerRespVo(Banner banner) {
        if ( banner == null ) {
            return null;
        }

        BannerRespVo bannerRespVo = new BannerRespVo();

        bannerRespVo.setTitle( banner.getTitle() );
        bannerRespVo.setCoverUrl( banner.getCoverUrl() );
        bannerRespVo.setLinkUrl( banner.getLinkUrl() );

        return bannerRespVo;
    }
}
