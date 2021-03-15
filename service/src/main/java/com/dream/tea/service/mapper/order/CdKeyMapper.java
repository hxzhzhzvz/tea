package com.dream.tea.service.mapper.order;

import com.dream.tea.service.model.order.CdKey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface CdKeyMapper {
    int deleteByPrimaryKey(Long id);

    /**
     * 进行兑换码的创建操作
     *
     * @param record 兑换码的对象
     * @return 操作结果
     */
    int insert(CdKey record);

    CdKey selectByPrimaryKey(Long id);

    List<CdKey> selectAll();

    int updateByPrimaryKey(CdKey record);
}