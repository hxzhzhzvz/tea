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
import com.dream.tea.service.cache.lock.LockService;
import com.dream.tea.service.common.bean.BusinessException;
import com.dream.tea.service.common.constants.RedisKeyPrefixConstants;
import com.dream.tea.service.model.user.User;
import com.dream.tea.service.service.user.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
@Api(tags = "user用户表相关")
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

    @Resource
    private LockService lockService;


    @ApiOperation("注册账号")
    @PostMapping("/register")
    public RespResult<RegisterRespVo> register(@RequestBody @Valid RegisterReqVo reqVo) {
        try {
            // 防止并发没有太大意义
            User user = UserVoConverter.INSTANCE.registerReqVoToUser(reqVo);
            userLoginService.register(user);
            JwtPayload jwtPayload = UserVoConverter.INSTANCE.userToJwtPayload(user);
            String token = secretUtils.createToken(jwtPayload);
            stringRedisTemplate.opsForValue().set(RedisKeyPrefixConstants.TOKEN_REDIS_KEY_PREFIX + token, RedisKeyPrefixConstants.TOKEN_REDIS_VALUE, jwtAuthConfig.getUserTokenExpireSecond(), TimeUnit.SECONDS);
            stringRedisTemplate.opsForValue().set(RedisKeyPrefixConstants.ACCOUNT_REDIS_KEY_PREFIX + user.getAccount(), token, jwtAuthConfig.getUserTokenExpireSecond(), TimeUnit.SECONDS);
            RegisterRespVo respVo = UserVoConverter.INSTANCE.tokenToRegisterRespVo(token);
            return RespResult.succeed(respVo);
        } catch (BusinessException e) {
            return RespResult.failed(e.getResultCodeEnum());
        }
    }

    @ApiOperation("登录操作")
    @PostMapping("/login")
    public RespResult<LoginRespVo> login(@RequestBody @Valid LoginReqVo reqVo) {
        try {
            String lockName = "loginLock:" + reqVo.getAccount();
            String lockValue = lockService.getLock(lockName);
            if (StringUtils.isBlank(lockValue)) {
                return RespResult.failed();
            }
            try {
                User user = userLoginService.login(reqVo.getAccount(), reqVo.getPassword());
                JwtPayload jwtPayload = UserVoConverter.INSTANCE.userToJwtPayload(user);
                String lastToken = stringRedisTemplate.opsForValue().get(RedisKeyPrefixConstants.ACCOUNT_REDIS_KEY_PREFIX + user.getAccount());
                if (StringUtils.isNotBlank(lastToken)) {
                    // 将旧token挤下线
                    stringRedisTemplate.delete(RedisKeyPrefixConstants.TOKEN_REDIS_KEY_PREFIX + lastToken);
                }
                String token = secretUtils.createToken(jwtPayload);
                stringRedisTemplate.opsForValue().set(RedisKeyPrefixConstants.TOKEN_REDIS_KEY_PREFIX + token, RedisKeyPrefixConstants.TOKEN_REDIS_VALUE, jwtAuthConfig.getUserTokenExpireSecond(), TimeUnit.SECONDS);
                stringRedisTemplate.opsForValue().set(RedisKeyPrefixConstants.ACCOUNT_REDIS_KEY_PREFIX + user.getAccount(), token, jwtAuthConfig.getUserTokenExpireSecond(), TimeUnit.SECONDS);
                LoginRespVo respVo = UserVoConverter.INSTANCE.tokenToLoginRespVo(token);
                return RespResult.succeed(respVo);
            } finally {
                lockService.releaseLock(lockName, lockValue);
            }
        } catch (BusinessException e) {
            return RespResult.failed(e.getResultCodeEnum());
        }
    }
}
