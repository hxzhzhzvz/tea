package com.dream.tea.service.common.bean;

import lombok.Getter;

/**
 * @author yongfa
 */
@Getter
public enum ResultCodeEnum {

    // 0表示成功
    SUCCESS(0, "OK"),

    // 1开头与登录有关
    ACCOUNT_NOT_EXISTS(101, "账号不存在"),
    PASSWORD_INCORRECT(102, "密码不正确"),
    TOO_MANY_ATTEMPTS_FOR_THIS_ACCOUNT(103, "短时间内该账号的尝试次数太多，有被恶意破解的风险。现该账户已被禁用，请10分钟后再重试！"),
    ACCOUNT_IS_EXISTS(104, "账号已经被存在，请换个账号重新注册"),
    NOT_LOGIN_YET(105, "身份校验失败，用户请先进行登录！"),

    // 2开头与表单校验有关
    FIELD_NOT_VALID(201, "表单校验失败"),

    // 3开头和资源有关
    SOURCE_NOT_VALID(301, "资源已经下架"),

    // 4开头的与访问权限有关
    ACCESS_IP_FAILED(401, "获取IP失败"),
    ACCESS_DENY(402, "访问拒绝");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 提示信息
     */
    private final String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
