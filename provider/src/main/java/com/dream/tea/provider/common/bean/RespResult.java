package com.dream.tea.provider.common.bean;


import com.dream.tea.service.common.bean.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @param <T>
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

    public RespResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 成功响应
     *
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> succeed() {
        return succeed(BaseResultCode.SUCCESS_MSG, null);
    }

    /**
     * 成功响应
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> succeed(T data) {
        return succeed(BaseResultCode.SUCCESS_MSG, data);
    }

    /**
     * 成功响应
     *
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> succeed(String msg, T data) {
        return new RespResult(BaseResultCode.SUCCESS_CODE, msg, data);
    }

    /**
     * 判断响应是否成功
     *
     * @return
     */
    public Boolean isSucceed() {
        return BaseResultCode.SUCCESS_CODE.equals(this.code);
    }

    /**
     * 响应失败
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> failed(String msg) {
        return failed(BaseResultCode.BASE_ERROR_CODE, msg);
    }

    /**
     * 响应失败
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> failed(Integer code, String msg) {
        return new RespResult(code, msg, null);
    }

    /**
     * 响应失败
     *
     * @param resultCodeEnum
     * @param <T>
     * @return
     */
    public static <T> RespResult<T> failed(ResultCodeEnum resultCodeEnum) {
        return new RespResult(resultCodeEnum.getCode(), resultCodeEnum.getMsg(), null);
    }

}
