package com.dream.tea.service.mapper.config;

import com.dream.tea.service.model.config.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface BannerMapper {


    /**
     * 通过状态获取到banner列表
     *
     * @param status 0是禁用状态，1是生效状态
     * @return
     */
    List<Banner> getBannerByStatus(Integer status);

}