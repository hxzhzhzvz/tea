package com.dream.tea.provider.vo.resp.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class RegisterRespVo {

    /**
     * 注册成功之后返回访问的token
     */
    @ApiModelProperty(value = "token")
    private String token;
}
