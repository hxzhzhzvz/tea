package com.dream.tea.provider.vo.resp.single;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LiYongFa
 */
@Data
@ApiModel
public class SingleVideoVo {

    @ApiModelProperty(value = "单节视频的id")
    private Long singleVideoId;

    @ApiModelProperty(value = "视频的名字")
    private String name;

    @ApiModelProperty(value = "视频的封面")
    private String coverUrl;

    @ApiModelProperty(value = "视频链接")
    private String videoUrl;

}
