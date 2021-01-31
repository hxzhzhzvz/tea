package com.dream.tea.service.common.bean;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
public class BusinessException extends IllegalArgumentException {

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
            return "服务器繁忙，请稍后重试！";
        }
    }
}
