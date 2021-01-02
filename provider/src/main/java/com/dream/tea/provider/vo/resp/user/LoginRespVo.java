package com.dream.tea.provider.vo.resp.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class LoginRespVo {

    /**
     * 登录的token
     */
    @ApiModelProperty(value = "登录的token")
    private String token;
}
