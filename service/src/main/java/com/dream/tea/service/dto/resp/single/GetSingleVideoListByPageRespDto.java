package com.dream.tea.service.dto.resp.single;

import com.dream.tea.service.model.library.SingleVideo;
import lombok.Data;

import java.util.List;

/**
 * @author LiYongFa
 */
@Data
public class GetSingleVideoListByPageRespDto {

    /**
     * 下一次分页查询的maxId参数
     */
    private Long maxId;

    /**
     * 是否还有下一页
     */
    private Integer hasNextPage;

    /**
     * 查询的结果
     */
    private List<SingleVideo> dataList;
}
