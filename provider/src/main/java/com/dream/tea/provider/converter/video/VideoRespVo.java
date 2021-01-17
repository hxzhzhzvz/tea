package com.dream.tea.provider.converter.video;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class VideoRespVo {

    @ApiModelProperty(value = "自增id")
    private Long videoId;

    @ApiModelProperty(value = "该视频所属的视频列表的id")
    private Long videoListId;

    @ApiModelProperty(value = "视频的名字")
    private String name;

    @ApiModelProperty(value = "视频的封面")
    private String coverUrl;

    @ApiModelProperty(value = "视频链接")
    private String videoUrl;

}
