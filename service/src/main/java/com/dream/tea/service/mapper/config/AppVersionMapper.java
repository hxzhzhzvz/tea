package com.dream.tea.service.mapper.config;

import com.dream.tea.service.model.config.AppVersion;
import org.springframework.stereotype.Repository;

/**
 * @author yongfa
 */
@Repository
public interface AppVersionMapper {


    /**
     * 获取最新的一条版本数据
     *
     * @return 升级策略
     */
    AppVersion getLatestOne();

}