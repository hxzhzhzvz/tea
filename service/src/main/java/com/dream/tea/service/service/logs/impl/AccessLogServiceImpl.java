package com.dream.tea.service.service.logs.impl;

import com.dream.tea.service.mapper.log.AccessLogMapper;
import com.dream.tea.service.model.log.AccessLog;
import com.dream.tea.service.service.logs.AccessLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Service
public class AccessLogServiceImpl implements AccessLogService {

    @Resource
    private AccessLogMapper accessLogMapper;

    @Override
    public void addAccessLog(Long userId, String uri) {
        AccessLog record = new AccessLog();
        record.setUserId(userId);
        record.setUri(uri);
        accessLogMapper.insert(record);
    }
}
