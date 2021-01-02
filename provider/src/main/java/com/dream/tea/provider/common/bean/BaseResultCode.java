package com.dream.tea.provider.common.bean;

/**
 * @author yongfa
 */
public class BaseResultCode {
    /**
     * 成功
     */
    public static final Integer SUCCESS_CODE = 0;
    /**
     * 成功
     */
    public static final String SUCCESS_MSG = "OK";
    /**
     * 通用失败状态码
     */
    public static final Integer BASE_ERROR_CODE = 101;
    /**
     * 通用失败提示
     */
    public static final String BASE_ERROR_MSG = "系统繁忙，请稍后再试！";
    /**
     * 表单校验失败
     */
    public static final Integer VALIDATE_FORM_DATA_FAILED_CODE = 102;

    /**
     * 表单校验失败
     */
    public static final String VALIDATE_FORM_DATA_FAILED_MSG = "表单校验失败";
    /**
     * 身份校验失败
     */
    public static final Integer AUTH_FAILED_CODE = 401;

    /**
     * 身份校验失败
     */
    public static final String AUTH_FAILED_MSG = "访问的token过期了";
    /**
     * 拒绝访问状态码
     */
    public static final Integer FORBIDDEN_CODE = 403;
}
