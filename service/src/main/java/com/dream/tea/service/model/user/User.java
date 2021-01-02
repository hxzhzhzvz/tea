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
     * 用户的出生日期
     */
    private Date birthday;

    /**
     * 用户的性别
     */
    private Integer sex;

    /**
     * 用户的昵称
     */
    private String nickName;

    /**
     * 用户的头像
     */
    private String hearUrl;

    /**
     * 账号的创建时间
     */
    private Date gmtCreate;

    /**
     * 记录的最近修改时间
     */
    private Date gmtUpdate;

}