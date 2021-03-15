package com.dream.tea.provider.vo.resp.single;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author LiYongFa
 */
@Data
@ApiModel
public class GetSingleVideoListByPageRespVo {

    @ApiModelProperty(value = "下一次分页查询参数")
    private Long maxId;

    @ApiModelProperty(value = "是否还有下一页")
    private Integer hasNextPage;

    @ApiModelProperty(value = "此次查询的结果")
    private List<SingleVideoVo> dataList;

}
