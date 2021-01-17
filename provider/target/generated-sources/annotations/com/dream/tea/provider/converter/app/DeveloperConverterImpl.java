package com.dream.tea.provider.converter.app;

import com.dream.tea.provider.vo.resp.app.DeveloperRespVo;
import com.dream.tea.service.model.config.Developer;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-17T17:08:11+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class DeveloperConverterImpl implements DeveloperConverter {

    @Override
    public DeveloperRespVo developerToRespVo(Developer developer) {
        if ( developer == null ) {
            return null;
        }

        DeveloperRespVo developerRespVo = new DeveloperRespVo();

        developerRespVo.setContent( developer.getContent() );

        return developerRespVo;
    }
}
