package com.dream.tea.provider.controller;

import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.common.login.annotation.LoginRequired;
import com.dream.tea.provider.common.login.utils.UserUtils;
import com.dream.tea.provider.converter.app.AppVersionConverter;
import com.dream.tea.provider.converter.app.DeveloperConverter;
import com.dream.tea.provider.vo.req.app.FeedbackReqVo;
import com.dream.tea.provider.vo.resp.app.AppVersionRespVo;
import com.dream.tea.provider.vo.resp.app.DeveloperRespVo;
import com.dream.tea.service.model.config.AppVersion;
import com.dream.tea.service.model.config.Developer;
import com.dream.tea.service.service.app.AppVersionService;
import com.dream.tea.service.service.app.DeveloperService;
import com.dream.tea.service.service.app.UserFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author yongfa
 */
@Api(tags = "app应用相关")
@RestController
@RequestMapping("/o/app")
public class AppSystemController {

    @Resource
    private AppVersionService appVersionService;

    @Resource
    private DeveloperService developerService;

    @Resource
    private UserFeedbackService userFeedbackService;

    @ApiOperation("获取应用的最新版本信息")
    @GetMapping("/getAppLatestVersion")
    public RespResult<AppVersionRespVo> getAppLatestVersion(@RequestParam("version") String version) {
        AppVersion appVersion = appVersionService.getAppLatestVersion();
        AppVersionRespVo respVo = AppVersionConverter.INSTANCE.appVersionToRespVo(appVersion);
        respVo.setNeedToUpgrade(respVo.getVersion().compareTo(version) > 0);
        return RespResult.succeed(respVo);
    }

    @ApiOperation("开发者说明")
    @GetMapping("/getDeveloperNotes")
    public RespResult<DeveloperRespVo> getDeveloperNotes() {
        Developer developer = developerService.getLatestOne();
        DeveloperRespVo respVo = DeveloperConverter.INSTANCE.developerToRespVo(developer);
        return RespResult.succeed(respVo);
    }

    @LoginRequired
    @ApiOperation("开发者说明")
    @PostMapping("/feedback")
    public RespResult<Void> feedback(@RequestBody @Valid FeedbackReqVo reqVo) {
        Long userId = UserUtils.getUserId();
        userFeedbackService.addUserFeedback(userId, reqVo.getContent());
        return RespResult.succeed();
    }
}
