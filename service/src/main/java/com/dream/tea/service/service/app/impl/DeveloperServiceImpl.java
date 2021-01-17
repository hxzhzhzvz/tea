package com.dream.tea.service.service.app.impl;

import com.dream.tea.service.mapper.config.DeveloperMapper;
import com.dream.tea.service.model.config.Developer;
import com.dream.tea.service.service.app.DeveloperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class DeveloperServiceImpl implements DeveloperService {

    @Resource
    private DeveloperMapper developerMapper;

    @Override
    public Developer getLatestOne() {
        return developerMapper.getLatestOne();
    }
}
