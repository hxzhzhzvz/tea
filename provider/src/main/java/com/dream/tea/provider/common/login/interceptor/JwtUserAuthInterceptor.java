package com.dream.tea.provider.common.login.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.dream.tea.provider.common.bean.BaseResultCode;
import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.common.login.TokenUserHelper;
import com.dream.tea.provider.common.login.annotation.LoginRequired;
import com.dream.tea.provider.common.login.config.JwtAuthConfig;
import com.dream.tea.provider.common.login.entity.JwtPayload;
import com.dream.tea.provider.common.login.utils.ResponseHelper;
import com.dream.tea.provider.common.login.utils.SecretUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yongfa
 */
@Slf4j
@Component
public class JwtUserAuthInterceptor implements HandlerInterceptor, Ordered {

    @Resource
    private JwtAuthConfig jwtAuthConfig;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SecretUtils secretUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LoginRequired loginRequired = getLoginRequiredAnnotation(handler);
        if (ObjectUtil.isNull(loginRequired)) {
            return true;
        }
        String authKey = request.getHeader(jwtAuthConfig.getAuthKey());
        if (StringUtils.isNotBlank(authKey)) {
            String jsonContentValue = stringRedisTemplate.opsForValue().get(jwtAuthConfig.getTokenRedisKeyPrefix() + authKey);
            if (StringUtils.isBlank(jsonContentValue)) {
                RespResult<Object> respResult = RespResult.failed(BaseResultCode.AUTH_FAILED_CODE, BaseResultCode.AUTH_FAILED_MSG);
                ResponseHelper.renderJson(response, JSONUtil.toJsonStr(respResult));
                return false;
            } else {
                JwtPayload jwtPayload = secretUtils.parseToken(authKey);
                TokenUserHelper.setCurrUser(jwtPayload);
                return true;
            }
        }
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TokenUserHelper.clear();
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    /**
     * 从请求处理器中的此次方法中获取到此次请求方法
     *
     * @param handler 被拦截的处理器
     * @return 注解对象
     */
    private LoginRequired getLoginRequiredAnnotation(Object handler) {
        LoginRequired loginRequired = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
            if (loginRequired == null) {
                loginRequired = handlerMethod.getBeanType().getAnnotation(LoginRequired.class);
            }
        }
        return loginRequired;
    }
}
