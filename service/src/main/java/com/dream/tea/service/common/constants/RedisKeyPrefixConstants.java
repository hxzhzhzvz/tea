package com.dream.tea.service.common.constants;

/**
 * 业务前缀常量
 *
 * @author yongfa
 */
public class RedisKeyPrefixConstants {

    /**
     * 用户反馈
     */
    public static final String FEEDBACK = "feedback:";

    /**
     * 无定制化的通用Redis锁业务前缀
     */
    public static final String COMMON_LOCK = "lock:";

    /**
     * 登录限制业务前缀
     */
    public static final String RESTRICT_LOGIN = "restrict:login:";

    /**
     * 访问请求业务
     */
    public static final String ACCESS = "access:";

    /**
     * token的业务前缀
     */
    public static final String TOKEN_REDIS_KEY_PREFIX = "token:";

    /**
     * 账号的业务前缀
     */
    public static final String ACCOUNT_REDIS_KEY_PREFIX = "account:";

    /**
     * token的默认取值
     */
    public static final String TOKEN_REDIS_VALUE = "login";
}
