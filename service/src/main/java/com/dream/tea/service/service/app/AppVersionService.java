package com.dream.tea.service.service.app;

import com.dream.tea.service.model.config.AppVersion;

/**
 * @author yongfa
 */
public interface AppVersionService {

    /**
     * 获取最新的一条版本数据
     *
     * @return 升级策略
     */
    AppVersion getAppLatestVersion();
}
