package com.dream.tea.provider.common.bean;


import com.dream.tea.service.common.bean.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yongfa
 */
@Data
public class RespResult<T> implements Serializable {
    /**
     * 返回的状态码
     */
    protected Integer code;
    /**
     * 返回的消息提示
     */
    protected String msg;

    /**
     * 返回的内容，vo的data
     */
    protected T data;

    public RespResult() {
    }

    public RespResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 成功响应
     *
     * @param <T> 返回data的泛型
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> succeed() {
        return succeed(BaseResultCode.SUCCESS_MSG, null);
    }

    /**
     * 成功响应
     *
     * @param data 返回的data
     * @param <T>  返回data的泛型
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> succeed(T data) {
        return succeed(BaseResultCode.SUCCESS_MSG, data);
    }

    /**
     * 成功响应
     *
     * @param <T>  返回data的泛型
     * @param msg  返回的提示信息
     * @param data 返回的data
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> succeed(String msg, T data) {
        return new RespResult<>(BaseResultCode.SUCCESS_CODE, msg, data);
    }

    /**
     * 判断响应是否成功
     *
     * @return 判断结果
     */
    public Boolean isSucceed() {
        return BaseResultCode.SUCCESS_CODE.equals(this.code);
    }


    /**
     * 响应失败
     *
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> failed() {
        return failed(BaseResultCode.BASE_ERROR_MSG);
    }

    /**
     * 响应失败
     *
     * @param msg 错误提示信息
     * @param <T> 返回的data的泛型
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> failed(String msg) {
        return failed(BaseResultCode.BASE_ERROR_CODE, msg);
    }

    /**
     * 响应失败
     *
     * @param <T>  返回的data的泛型
     * @param code 返回的错误码
     * @param msg  错误提示信息
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> failed(Integer code, String msg) {
        return new RespResult<>(code, msg);
    }

    /**
     * 响应失败
     *
     * @param resultCodeEnum 错误的信息枚举
     * @param <T>            返回的data的泛型
     * @return 返回的vo封装对象
     */
    public static <T> RespResult<T> failed(ResultCodeEnum resultCodeEnum) {
        return failed(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
    }

}
