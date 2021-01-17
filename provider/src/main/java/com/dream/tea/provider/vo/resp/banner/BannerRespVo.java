package com.dream.tea.provider.vo.resp.banner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class BannerRespVo {

    @ApiModelProperty(value = "banner的title")
    private String title;

    @ApiModelProperty(value = "banner的封面url")
    private String coverUrl;

    @ApiModelProperty(value = "banner的跳转链接，可能为空")
    private String linkUrl;

}
