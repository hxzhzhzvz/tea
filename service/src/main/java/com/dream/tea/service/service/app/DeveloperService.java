package com.dream.tea.service.service.app;

import com.dream.tea.service.model.config.Developer;

/**
 * @author yongfa
 */
public interface DeveloperService {

    /**
     * 获取到最新的一条开发者说明记录
     *
     * @return
     */
    Developer getLatestOne();
}
