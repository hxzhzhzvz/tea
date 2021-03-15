package com.dream.tea.service.service.video;

import com.dream.tea.service.dto.req.single.GetSingleVideoListByPageReqDto;
import com.dream.tea.service.dto.resp.single.GetSingleVideoListByPageRespDto;

/**
 * @author yongfa
 */
public interface SingleVideoService {

    /**
     * 分页获取SingleVideo数据
     *
     * @param reqDto 查询参数
     * @return 查询结果
     */
    GetSingleVideoListByPageRespDto getSingleVideoListByPage(GetSingleVideoListByPageReqDto reqDto);
}
