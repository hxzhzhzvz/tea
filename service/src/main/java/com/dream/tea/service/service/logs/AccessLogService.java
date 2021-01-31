package com.dream.tea.service.service.logs;

/**
 * @author yongfa
 */
public interface AccessLogService {

    /**
     * 添加访问日志
     *
     * @param userId 访问用户的id，可为null
     * @param uri    访问的uri
     */
    void addAccessLog(Long userId, String uri);
}
