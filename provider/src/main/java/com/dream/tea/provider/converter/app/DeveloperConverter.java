package com.dream.tea.provider.converter.app;

import com.dream.tea.provider.vo.resp.app.DeveloperRespVo;
import com.dream.tea.service.model.config.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author yongfa
 */
@Mapper
public interface DeveloperConverter {

    DeveloperConverter INSTANCE = Mappers.getMapper(DeveloperConverter.class);

    /**
     * 将开发者信息说明对象转换成VO对象
     *
     * @param developer entity对象
     * @return VO对象
     */
    DeveloperRespVo developerToRespVo(Developer developer);

}
