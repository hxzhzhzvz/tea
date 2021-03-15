package com.dream.tea.provider.vo.req.cdkey;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Map;

/**
 * @author LiYongFa
 */
@Data
@ApiModel
public class BatchCreateCdKeyReqVo {

    @NotNull(message = "业务类型不能为null")
    @ApiModelProperty(value = "业务类型，现在默认是1")
    private Integer bizType = 1;

    @ApiModelProperty(value = "过期时间，可以为null")
    private Date expireTime;

    @Min(value = 1, message = "生成的兑换码数量需要大于0")
    @Max(value = 1000, message = "生成的兑换码数量一次性不能超过1000")
    @NotNull(message = "需要指定兑换码的生成数量")
    @ApiModelProperty(value = "生成的兑换码数量", required = true)
    private Integer quantity;

    @ApiModelProperty(value = "扩展信息")
    private Map<String, Object> extendInfo;

}
