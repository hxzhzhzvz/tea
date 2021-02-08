package com.dream.tea.service.common.bean;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author yongfa
 */
public class BusinessException extends IllegalArgumentException {

    /**
     * 异常信息枚举类
     */
    private ResultCodeEnum resultCodeEnum;

    public BusinessException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }

    public Integer getCode() {
        if (ObjectUtil.isNotNull(resultCodeEnum)) {
            return resultCodeEnum.getCode();
        } else {
            return -1;
        }
    }

    public String getMsg() {
        if (ObjectUtil.isNotNull(resultCodeEnum)) {
            return resultCodeEnum.getMsg();
        } else {
            return ResultCodeEnum.COMMON_FAILED.getMsg();
        }
    }

    public ResultCodeEnum getResultCodeEnum() {
        return resultCodeEnum;
    }

    public void setResultCodeEnum(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }
}
