package com.dream.tea.provider.vo.req.user;

import com.dream.tea.service.enums.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

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

    /**
     * 用户的出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    /**
     * 用户的性别
     */
    @Min(0)
    @Max(3)
    @ApiModelProperty(value = "性别")
    private Integer sex = SexEnum.UNKNOWN.getSex();

    /**
     * 用户的昵称
     */
    @Length(max = 20, message = "昵称的最大长度不能超过20个字")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    /**
     * 用户的头像
     */
    @ApiModelProperty(value = "头像")
    private String hearUrl;

}
