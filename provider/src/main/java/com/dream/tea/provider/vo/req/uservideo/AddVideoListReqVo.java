package com.dream.tea.provider.vo.req.uservideo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class AddVideoListReqVo {

    @NotNull(message = "视频列表id资源不能为null")
    @ApiModelProperty(value = "视频资源列表id")
    private Long videoListId;
}
