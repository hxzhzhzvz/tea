package com.dream.tea.service.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author LiYongFa
 */
@Component
public class ToolsHolder implements ApplicationRunner {

    @Resource
    private SpringUtils rawSpringUtils;

    public static SpringUtils springUtils;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        springUtils = rawSpringUtils;
    }
}
