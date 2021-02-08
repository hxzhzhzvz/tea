package com.dream.tea.provider.common.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.provider.common.login.utils.ResponseHelper;
import com.dream.tea.provider.common.login.utils.UserUtils;
import com.dream.tea.provider.utils.IpUtils;
import com.dream.tea.service.common.bean.ResultCodeEnum;
import com.dream.tea.service.common.constants.RedisKeyPrefixConstants;
import com.dream.tea.service.service.logs.AccessLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

import static com.dream.tea.service.common.bean.ResultCodeEnum.ACCESS_DENY;
import static com.dream.tea.service.common.bean.ResultCodeEnum.ACCESS_IP_FAILED;

/**
 * @author yongfa
 */
@Slf4j
@Component
public class AccessCountInterceptor implements HandlerInterceptor, Ordered {

    /**
     * 业务前缀
     */
    private static final String KEY_PREFIX = RedisKeyPrefixConstants.ACCESS;

    private static final int ONE_HOUR_ACCESS_LIMIT = 500;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserUtils userUtils;

    @Resource
    private AccessLogService accessLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 记录访问日志，用来日后做用户分析
        try {
            Long userId = userUtils.getUserIdFromRequest(request);
            String uri = request.getRequestURI();
            accessLogService.addAccessLog(userId, uri);
        } catch (Exception e) {
            // 打少一点日志，没钱
            log.error("记录访问日志异常:{}", e.getMessage());
        }
        // 起到网关限流作用，过滤掉异常访问请求
        boolean result = false;
        String ipAddr = IpUtils.getIpAddr(request);
        if (StringUtils.isBlank(ipAddr)) {
            ResultCodeEnum resultCodeEnum = ACCESS_IP_FAILED;
            RespResult<Object> respResult = RespResult.failed(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
            ResponseHelper.renderJson(response, JSONUtil.toJsonStr(respResult));
            result = false;
        } else {
            String key = KEY_PREFIX + ipAddr;
            Boolean setRes = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 1, TimeUnit.HOURS);
            if (ObjectUtil.isNotNull(setRes)) {
                if (setRes) {
                    result = true;
                } else {
                    Long incrRes = stringRedisTemplate.opsForValue().increment(key);
                    if (ObjectUtil.isNull(incrRes) || (incrRes >= ONE_HOUR_ACCESS_LIMIT)) {
                        ResultCodeEnum resultCodeEnum = ACCESS_DENY;
                        RespResult<Object> respResult = RespResult.failed(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
                        ResponseHelper.renderJson(response, JSONUtil.toJsonStr(respResult));
                        result = false;
                    } else {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
