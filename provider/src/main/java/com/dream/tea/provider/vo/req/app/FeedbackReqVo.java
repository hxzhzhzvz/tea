package com.dream.tea.provider.vo.req.app;

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
public class FeedbackReqVo {

    @NotBlank
    @Length(min = 1, max = 500, message = "反馈的内容长度范围只能在1到500之间")
    @ApiModelProperty(value = "反馈的内容")
    private String content;
}
