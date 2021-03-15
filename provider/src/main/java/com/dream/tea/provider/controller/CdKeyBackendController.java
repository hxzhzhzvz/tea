package com.dream.tea.provider.controller;

import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.converter.cdkey.CdKeyConverter;
import com.dream.tea.provider.vo.req.cdkey.BatchCreateCdKeyReqVo;
import com.dream.tea.provider.vo.resp.cdkey.BatchCreateCdKeyRespVo;
import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import com.dream.tea.service.service.cdkey.CdKeyManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiYongFa
 */
@Api(tags = "兑换码管理后台相关相关")
@RestController
@RequestMapping("/o/oa/cdKey")
public class CdKeyBackendController {

    @Resource
    private CdKeyManagerService cdKeyManagerService;

    @ApiOperation("进行二维码的兑换操作")
    @PostMapping("/batchCreateCdKey")
    public RespResult<BatchCreateCdKeyRespVo> batchCreateCdKey(@RequestBody  BatchCreateCdKeyReqVo reqVo) {
        BatchCreateCdKeyReqDto reqDto = CdKeyConverter.INSTANCE.batchCreateCdKeyReqVoToDto(reqVo);
        BatchCreateCdKeyRespDto respDto = cdKeyManagerService.batchCreateCdKey(reqDto);
        BatchCreateCdKeyRespVo respVo = CdKeyConverter.INSTANCE.batchCreateCdKeyRespDtoToVo(respDto);
        return RespResult.succeed(respVo);
    }
}
