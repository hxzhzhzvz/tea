package com.dream.tea.service.mapper.log;

import com.dream.tea.service.model.log.AccessLog;
import org.springframework.stereotype.Repository;

/**
 * @author yongfa
 */
@Repository
public interface AccessLogMapper {

    /**
     * 插入访问记录
     *
     * @param record 记录对象
     * @return 操作结果
     */
    int insert(AccessLog record);

}