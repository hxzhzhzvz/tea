package com.dream.tea.provider.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author yongfa
 * 注册账号vo
 */
@Data
@ApiModel
public class RegisterReqVo {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    @Pattern(regexp = "^[0-9a-zA-Z]{8,18}$", message = "账号只能是8到18个字母或者数字")
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = " 密码")
    @Pattern(regexp = "^[0-9a-zA-Z]{8,18}$", message = "密码只能是8到18个字母或者数字")
    @ApiModelProperty(value = "密码")
    private String password;

}
