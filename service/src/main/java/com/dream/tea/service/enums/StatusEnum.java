package com.dream.tea.service.enums;

import lombok.Getter;

/**
 * @author yongfa
 */
@Getter
public enum StatusEnum {

    ZERO(0, "禁用"),
    ONE(1, "使用中");

    /**
     * 使用状态
     */
    private Integer status;

    /**
     * 文字描述
     */
    private String description;

    StatusEnum(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}
