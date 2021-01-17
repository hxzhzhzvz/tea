package com.dream.tea.provider.converter.app;

import com.dream.tea.provider.vo.resp.app.AppVersionRespVo;
import com.dream.tea.service.model.config.AppVersion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author yongfa
 */
@Mapper
public interface AppVersionConverter {

    AppVersionConverter INSTANCE = Mappers.getMapper(AppVersionConverter.class);

    /**
     * 将版本升级对象转换成vo对象
     *
     * @param appVersion 版本对象
     * @return 转成成的vo对象
     */
    AppVersionRespVo appVersionToRespVo(AppVersion appVersion);
}
