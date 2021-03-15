package com.dream.tea.provider.converter.cdkey;

import com.dream.tea.provider.vo.req.cdkey.BatchCreateCdKeyReqVo;
import com.dream.tea.provider.vo.resp.cdkey.BatchCreateCdKeyRespVo;
import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-14T18:10:41+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class CdKeyConverterImpl implements CdKeyConverter {

    @Override
    public BatchCreateCdKeyReqDto batchCreateCdKeyReqVoToDto(BatchCreateCdKeyReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        BatchCreateCdKeyReqDto batchCreateCdKeyReqDto = new BatchCreateCdKeyReqDto();

        batchCreateCdKeyReqDto.setBizType( reqVo.getBizType() );
        batchCreateCdKeyReqDto.setExpireTime( reqVo.getExpireTime() );
        batchCreateCdKeyReqDto.setQuantity( reqVo.getQuantity() );
        Map<String, Object> map = reqVo.getExtendInfo();
        if ( map != null ) {
            batchCreateCdKeyReqDto.setExtendInfo( new HashMap<String, Object>( map ) );
        }

        return batchCreateCdKeyReqDto;
    }

    @Override
    public BatchCreateCdKeyRespVo batchCreateCdKeyRespDtoToVo(BatchCreateCdKeyRespDto respDto) {
        if ( respDto == null ) {
            return null;
        }

        BatchCreateCdKeyRespVo batchCreateCdKeyRespVo = new BatchCreateCdKeyRespVo();

        batchCreateCdKeyRespVo.setExchangeUrl( respDto.getExchangeUrl() );
        List<String> list = respDto.getCdCodeList();
        if ( list != null ) {
            batchCreateCdKeyRespVo.setCdCodeList( new ArrayList<String>( list ) );
        }

        return batchCreateCdKeyRespVo;
    }
}
