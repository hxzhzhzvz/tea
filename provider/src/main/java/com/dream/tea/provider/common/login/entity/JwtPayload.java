package com.dream.tea.provider.common.login.entity;

import lombok.Data;

/**
 * @author yongfa
 */
@Data
public class JwtPayload {

    /**
     * 用户的id
     */
    private Long userId;

    /**
     * 用户的注册手机号
     */
    private String phone;

}
