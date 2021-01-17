package com.dream.tea.service.service.banner.impl;

import com.dream.tea.service.enums.StatusEnum;
import com.dream.tea.service.mapper.config.BannerMapper;
import com.dream.tea.service.model.config.Banner;
import com.dream.tea.service.service.banner.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongfa
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getBannerList() {
        return bannerMapper.getBannerByStatus(StatusEnum.ONE.getStatus());
    }
}
