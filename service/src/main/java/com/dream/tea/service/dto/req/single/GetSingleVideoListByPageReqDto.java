package com.dream.tea.service.dto.req.single;

import lombok.Data;

/**
 * @author LiYongFa
 */
@Data
public class GetSingleVideoListByPageReqDto {

    /**
     * 每次查询的最多返回条数
     */
    private Integer limitSize;

    /**
     * 最大的maxId
     */
    private Long maxId;
}
