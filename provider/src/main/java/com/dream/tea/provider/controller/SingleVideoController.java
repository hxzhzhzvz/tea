package com.dream.tea.provider.controller;

import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.common.login.annotation.LoginRequired;
import com.dream.tea.provider.converter.single.SingleVideoConverter;
import com.dream.tea.provider.vo.req.single.GetSingleVideoListByPageReqVo;
import com.dream.tea.provider.vo.resp.single.GetSingleVideoListByPageRespVo;
import com.dream.tea.service.dto.req.single.GetSingleVideoListByPageReqDto;
import com.dream.tea.service.dto.resp.single.GetSingleVideoListByPageRespDto;
import com.dream.tea.service.service.video.SingleVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author LiYongFa
 */
@Api(tags = "单节视频加载相关")
@RestController
@RequestMapping("/o/singleVideo")
public class SingleVideoController {

    @Resource
    private SingleVideoService singleVideoService;

    @LoginRequired
    @ApiOperation("分页获取用户的单节视频")
    @PostMapping("/getSingleVideoListByPage")
    public RespResult<GetSingleVideoListByPageRespVo> getSingleVideoListByPage(@RequestBody @Valid GetSingleVideoListByPageReqVo reqVo) {
        GetSingleVideoListByPageReqDto reqDto = SingleVideoConverter.INSTANCE.getSingleVideoListByPageReqVoToDto(reqVo);
        GetSingleVideoListByPageRespDto respDto = singleVideoService.getSingleVideoListByPage(reqDto);
        GetSingleVideoListByPageRespVo respVo = SingleVideoConverter.INSTANCE.getSingleVideoListByPageRespDtoToVo(respDto);
        return RespResult.succeed(respVo);
    }
}
