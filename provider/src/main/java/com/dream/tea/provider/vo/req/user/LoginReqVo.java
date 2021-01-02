package com.dream.tea.provider.vo.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class LoginReqVo {

    /**
     * 账号
     */
    @Length(min = 8, max = 18, message = "账号是8到18位的数字或者字母")
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 密码
     */
    @Length(min = 8, max = 18, message = "密码是8到18位的数字或者字母")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;
}
