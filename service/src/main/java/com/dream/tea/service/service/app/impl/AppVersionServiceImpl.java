package com.dream.tea.service.service.app.impl;

import com.dream.tea.service.mapper.config.AppVersionMapper;
import com.dream.tea.service.model.config.AppVersion;
import com.dream.tea.service.service.app.AppVersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion getAppLatestVersion() {
        return appVersionMapper.getLatestOne();
    }
}
