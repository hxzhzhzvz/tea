package com.dream.tea.provider.vo.resp.video;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yongfa
 */
@Data
@ApiModel
public class VideoListRespVo {

    @ApiModelProperty(value = "视频列表的id")
    private Long videoListId;

    @ApiModelProperty(value = "视频列表的名字")
    private String name;

    @ApiModelProperty(value = "视频列表的封面")
    private String coverUrl;


}
