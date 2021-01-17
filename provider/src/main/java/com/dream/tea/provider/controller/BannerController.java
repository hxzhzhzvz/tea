package com.dream.tea.provider.controller;


import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.converter.banner.BannerVoConverter;
import com.dream.tea.provider.vo.resp.banner.BannerRespVo;
import com.dream.tea.service.model.config.Banner;
import com.dream.tea.service.service.banner.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yongfa
 */
@Api(tags = "banner广告位")
@RestController
@RequestMapping("/o/banner")
public class BannerController {

    @Resource
    private BannerService bannerService;

    @ApiOperation("获取banner列表")
    @GetMapping("/getBannerList")
    public RespResult<List<BannerRespVo>> getBannerList() {
        List<Banner> bannerList = bannerService.getBannerList();
        List<BannerRespVo> respVo = BannerVoConverter.INSTANCE.bannerListToBannerVoList(bannerList);
        return RespResult.succeed(respVo);
    }
}
