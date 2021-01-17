package com.dream.tea.provider.vo.resp.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class DeveloperRespVo {

    @ApiModelProperty(value = "开发者说明")
    private String content;
}
