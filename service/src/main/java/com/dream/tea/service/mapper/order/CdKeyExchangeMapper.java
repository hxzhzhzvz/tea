package com.dream.tea.service.mapper.order;

import com.dream.tea.service.model.order.CdKeyExchange;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface CdKeyExchangeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CdKeyExchange record);

    CdKeyExchange selectByPrimaryKey(Long id);

    List<CdKeyExchange> selectAll();

    int updateByPrimaryKey(CdKeyExchange record);
}