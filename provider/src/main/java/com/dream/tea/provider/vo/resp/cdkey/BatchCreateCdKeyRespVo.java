package com.dream.tea.provider.vo.resp.cdkey;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author LiYongFa
 */
@Data
@ApiModel
public class BatchCreateCdKeyRespVo {

    @ApiModelProperty(value = "对应的兑换链接")
    private String exchangeUrl = "";

    @ApiModelProperty(value = "生成的兑换码")
    private List<String> cdCodeList;
}
