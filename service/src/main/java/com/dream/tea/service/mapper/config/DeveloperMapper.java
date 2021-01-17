package com.dream.tea.service.mapper.config;

import com.dream.tea.service.model.config.Developer;
import org.springframework.stereotype.Repository;

/**
 * @author yongfa
 */
@Repository
public interface DeveloperMapper {

    /**
     * 获取到最新的一条开发者说明记录
     *
     * @return
     */
    Developer getLatestOne();

}