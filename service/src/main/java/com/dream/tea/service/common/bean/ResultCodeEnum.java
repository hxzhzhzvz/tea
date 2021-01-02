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

    // 2开头与表单校验有关
    FIELD_NOT_VALID(201, "表单校验失败"),

    LOGIN_NUM_LIMIT_ERROR(610, "登录次数过多、请之后再试"),
    LOGIN_ACCOUNT_NOT_EXIST(601, "该账号不存在"),
    LOGIN_ACCOUNT_LOCKED(602, "账号已被锁定"),
    LOGIN_PASSWORD_ERROR(603, "密码错误"),
    DUPLICATEKEY_ERROR(604, "主键id重复"),

    // 参数验证
    PARAM_ERROR(-5, "param error"),
    REQUEST_ERROR_METHOD(-5, "request_error_method"),
    INVALID_ERROR(-5, "参数校验异常"),
    NOT_NULL(-5, "%s 不能为null value:null"),
    INVALID_TYPE(-5, "%s 参数类型不正确 value:%s"),
    INVALID_PARAM(-5, "%s参数格式不正确,value:%s,提示:%s"),
    INVALID_BODY_PARAM(-5, "请求体不正确：%s"),

    //录播课业务异常 100 100 001
    NULL_RECORD(100100001, "记录为空"),
    //SQL错误
    SQL_ERRRO(100100002, "数据库查询有误,请联系管理员处理"),

    UN_KNOW(-1, "未知错误");

    private final Integer code;
    private final String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
