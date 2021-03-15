package com.dream.tea.provider.vo.req.single;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LiYongFa
 */
@Data
@ApiModel
public class GetSingleVideoListByPageReqVo {

    @ApiModelProperty(value = "查询返回的条数", required = true)
    private Integer limitSize = 20;

    @ApiModelProperty(value = "此次的自增id的最大值上限", required = true)
    private Long maxId = Long.MAX_VALUE;
}
