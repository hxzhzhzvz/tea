package com.dream.tea.service.common.bean;

import lombok.Data;

/**
 * @author yongfa
 */
@Data
public class CommonBusinessException extends IllegalArgumentException {

    private ResultCodeEnum resultCodeEnum;

    public CommonBusinessException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }
}
