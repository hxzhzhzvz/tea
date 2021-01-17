package com.dream.tea.service.service.banner;

import com.dream.tea.service.model.config.Banner;

import java.util.List;

/**
 * @author yongfa
 */
public interface BannerService {

    /**
     * 获取到目前所有正在生效中的banner
     *
     * @return banner列表
     */
    List<Banner> getBannerList();
}
