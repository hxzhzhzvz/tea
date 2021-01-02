package com.dream.tea.service.enums;

import lombok.Getter;

/**
 * @author yongfa
 */
@Getter
public enum SexEnum {

    UNKNOWN(0),
    BOY(1),
    GIRL(2);

    private Integer sex;

    SexEnum(Integer sex) {
        this.sex = sex;
    }
}
