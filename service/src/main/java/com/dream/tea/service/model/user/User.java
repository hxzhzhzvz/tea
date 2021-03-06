package com.dream.tea.service.model.user;

import lombok.Data;

import java.util.Date;

/**
 * @author yongfa
 */
@Data
public class User {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号的创建时间
     */
    private Date gmtCreate;

    /**
     * 记录的最近修改时间
     */
    private Date gmtUpdate;

}