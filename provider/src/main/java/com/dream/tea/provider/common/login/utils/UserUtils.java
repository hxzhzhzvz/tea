package com.dream.tea.provider.common.login.utils;

import com.dream.tea.provider.common.login.TokenUserHelper;
import com.dream.tea.provider.common.login.config.JwtAuthConfig;
import com.dream.tea.provider.common.login.entity.JwtPayload;
import com.dream.tea.service.common.constants.RedisKeyPrefixConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yongfa
 */
@Component
public class UserUtils {

    @Resource
    private JwtAuthConfig jwtAuthConfig;

    @Resource
    private SecretUtils secretUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取当前用户的userId
     *
     * @return 用户的id
     */
    public static Long getUserId() {
        return TokenUserHelper.getCurrUser().getUserId();
    }

    /**
     * 获取当前用户
     *
     * @return 用户的信息的载荷
     */
    public static JwtPayload getCurrentUser() {
        return TokenUserHelper.getCurrUser();
    }

    /**
     * 直接从请求request中解析用户的id取值
     * 该方法和使用@LoginRequire注解得到的UserId的效果是一样的
     *
     * @param request http的请求对象
     * @return 返回解析到的用户id，解析不出来时返回null
     */
    public Long getUserIdFromRequest(HttpServletRequest request) {
        String authKey = request.getHeader(jwtAuthConfig.getAuthKey());
        if (StringUtils.isNotBlank(authKey)) {
            String jsonContentValue = stringRedisTemplate.opsForValue().get(RedisKeyPrefixConstants.TOKEN_REDIS_KEY_PREFIX + authKey);
            if (StringUtils.isNotBlank(jsonContentValue)) {
                JwtPayload jwtPayload = secretUtils.parseToken(authKey);
                return jwtPayload.getUserId();
            }
        }
        return null;
    }
}