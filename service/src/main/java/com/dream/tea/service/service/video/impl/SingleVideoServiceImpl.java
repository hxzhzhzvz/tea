package com.dream.tea.service.service.video.impl;

import com.dream.tea.service.dto.req.single.GetSingleVideoListByPageReqDto;
import com.dream.tea.service.dto.resp.single.GetSingleVideoListByPageRespDto;
import com.dream.tea.service.mapper.library.SingleVideoMapper;
import com.dream.tea.service.model.library.SingleVideo;
import com.dream.tea.service.service.video.SingleVideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiYongFa
 */
@Service
public class SingleVideoServiceImpl implements SingleVideoService {

    @Resource
    private SingleVideoMapper singleVideoMapper;

    @Override
    public GetSingleVideoListByPageRespDto getSingleVideoListByPage(GetSingleVideoListByPageReqDto reqDto) {
        GetSingleVideoListByPageRespDto respDto = new GetSingleVideoListByPageRespDto();
        List<SingleVideo> dataList = singleVideoMapper.getByMaxIdAndLimitSize(reqDto.getMaxId(), reqDto.getLimitSize() + 1);
        if (dataList.size() > reqDto.getLimitSize()) {
            respDto.setMaxId(dataList.get(dataList.size() - 1).getId());
            dataList.remove(dataList.size() - 1);
            respDto.setHasNextPage(1);
        } else {
            respDto.setMaxId(0L);
            respDto.setHasNextPage(0);
        }
        respDto.setDataList(dataList);
        return respDto;
    }
}
