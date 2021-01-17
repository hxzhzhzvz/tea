package com.dream.tea.provider.converter.app;

import com.dream.tea.provider.vo.resp.app.AppVersionRespVo;
import com.dream.tea.service.model.config.AppVersion;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T17:08:11+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class AppVersionConverterImpl implements AppVersionConverter {

    @Override
    public AppVersionRespVo appVersionToRespVo(AppVersion appVersion) {
        if ( appVersion == null ) {
            return null;
        }

        AppVersionRespVo appVersionRespVo = new AppVersionRespVo();

        appVersionRespVo.setTitle( appVersion.getTitle() );
        appVersionRespVo.setContent( appVersion.getContent() );
        appVersionRespVo.setVersion( appVersion.getVersion() );
        appVersionRespVo.setUrl( appVersion.getUrl() );

        return appVersionRespVo;
    }
}
