package com.dream.tea.service.common.bean;

import lombok.Data;

/**
 * @author yongfa
 */
@Data
public class BaseCommonException extends RuntimeException {

    private ResultCodeEnum resultCodeEnum;

    public BaseCommonException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }
}
