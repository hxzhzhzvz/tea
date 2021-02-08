package com.dream.tea.service.enums;

import lombok.Getter;

/**
 * @author yongfa
 */
@Getter
public enum SexEnum {

    /**
     * 性别枚举类
     */
    UNKNOWN(0, "未知"),
    BOY(1, "男孩"),
    GIRL(2, "女孩");

    /**
     * 性别类型
     */
    private final Integer sex;

    /**
     * 描述
     */
    private final String description;

    SexEnum(Integer sex1, String description) {
        this.sex = sex1;
        this.description = description;
    }

    /**
     * 通过sex获取到对应的枚举类
     *
     * @param sex 类型取值
     * @return 枚举对象
     */
    public static SexEnum of(Integer sex) {
        for (SexEnum value : SexEnum.values()) {
            if (value.getSex().equals(sex)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
