package com.dream.tea.provider.converter.cdkey;

import com.dream.tea.provider.vo.req.cdkey.BatchCreateCdKeyReqVo;
import com.dream.tea.provider.vo.resp.cdkey.BatchCreateCdKeyRespVo;
import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author LiYongFa
 */
@Mapper
public interface CdKeyConverter {

    CdKeyConverter INSTANCE = Mappers.getMapper(CdKeyConverter.class);

    /**
     * 将创建兑换码的VO对象转换成DTO对象
     *
     * @param reqVo VO对象
     * @return 转换之后的DTO对象
     */
    BatchCreateCdKeyReqDto batchCreateCdKeyReqVoToDto(BatchCreateCdKeyReqVo reqVo);

    /**
     * 将创建兑换码返回的DTO对象转换成VO对象
     *
     * @param respDto DTO对象
     * @return 转换之后的VO对象
     */
    BatchCreateCdKeyRespVo batchCreateCdKeyRespDtoToVo(BatchCreateCdKeyRespDto respDto);
}
