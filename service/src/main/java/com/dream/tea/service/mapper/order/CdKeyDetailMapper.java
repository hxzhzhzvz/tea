package com.dream.tea.service.mapper.order;

import com.dream.tea.service.model.order.CdKeyDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface CdKeyDetailMapper {
    int deleteByPrimaryKey(Long id);

    /**
     * 进行兑换码的批量新增操作
     *
     * @param cdKeyDetailList 新增兑换码的集合
     * @return 操作结果
     */
    int batchInsert(@Param("cdKeyDetailList") List<CdKeyDetail> cdKeyDetailList);

    CdKeyDetail selectByPrimaryKey(Long id);

    List<CdKeyDetail> selectAll();

    int updateByPrimaryKey(CdKeyDetail record);
}