package com.dream.tea.provider.vo.resp.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class AppVersionRespVo {

    @ApiModelProperty(value = "是否需要进行升级操作")
    private Boolean needToUpgrade;

    @ApiModelProperty(value = "更新title")
    private String title;

    @ApiModelProperty(value = "更新的内容")
    private String content;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "下载链接")
    private String url;
}
