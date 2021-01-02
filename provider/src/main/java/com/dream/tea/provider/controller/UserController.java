package com.dream.tea.provider.controller;

import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.common.login.config.JwtAuthConfig;
import com.dream.tea.provider.common.login.entity.JwtPayload;
import com.dream.tea.provider.common.login.utils.SecretUtils;
import com.dream.tea.provider.converter.user.UserVoConverter;
import com.dream.tea.provider.vo.req.user.LoginReqVo;
import com.dream.tea.provider.vo.req.user.RegisterReqVo;
import com.dream.tea.provider.vo.resp.user.LoginRespVo;
import com.dream.tea.provider.vo.resp.user.RegisterRespVo;
import com.dream.tea.service.common.bean.BaseCommonException;
import com.dream.tea.service.model.user.User;
import com.dream.tea.service.service.user.UserLoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * @author yongfa
 */
@RestController
@RequestMapping("/o/user")
public class UserController {

    @Resource
    private JwtAuthConfig jwtAuthConfig;

    @Resource
    private SecretUtils secretUtils;

    @Resource
    private UserLoginService userLoginService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @ApiOperation("注册账号")
    @PostMapping("/register")
    public RespResult<RegisterRespVo> register(@RequestBody @Valid RegisterReqVo reqVo) {
        try {
            User user = UserVoConverter.INSTANCE.registerReqVoToUser(reqVo);
            userLoginService.register(user);
            JwtPayload jwtPayload = UserVoConverter.INSTANCE.userToJwtPayload(user);
            String token = secretUtils.createToken(jwtPayload);
            stringRedisTemplate.opsForValue().set(jwtAuthConfig.getTokenRedisKeyPrefix() + token, jwtAuthConfig.getTokenRedisValue(), jwtAuthConfig.getUserTokenExpireSecond(), TimeUnit.SECONDS);
            RegisterRespVo respVo = UserVoConverter.INSTANCE.tokenToRegisterRespVo(token);
            return RespResult.succeed(respVo);
        } catch (BaseCommonException e) {
            return RespResult.failed(e.getResultCodeEnum());
        }
    }

    @ApiOperation("登录操作")
    @PostMapping("/login")
    public RespResult<LoginRespVo> login(@RequestBody @Valid LoginReqVo reqVo) {
        try {
            User user = userLoginService.login(reqVo.getAccount(), reqVo.getPassword());
            JwtPayload jwtPayload = UserVoConverter.INSTANCE.userToJwtPayload(user);
            String token = secretUtils.createToken(jwtPayload);
            stringRedisTemplate.opsForValue().set(jwtAuthConfig.getTokenRedisKeyPrefix() + token, jwtAuthConfig.getTokenRedisValue(), jwtAuthConfig.getUserTokenExpireSecond(), TimeUnit.SECONDS);
            LoginRespVo respVo = UserVoConverter.INSTANCE.tokenToLoginRespVo(token);
            return RespResult.succeed(respVo);
        } catch (BaseCommonException e) {
            return RespResult.failed(e.getResultCodeEnum());
        }
    }
}
