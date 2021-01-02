package com.dream.tea.service.common.db.slave;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @author liyongfa
 * 动态数据库在主从库切换的时候用得到
 */
public class DynamicDataSourceAspect {

    private static final String BASE_MAPPER_PACKAGE_PREFIX = "com.dream.tea.service.mapper.";

    @Around(value = "execution( * com.dream.tea.service.mapper..*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            String targetClassName = joinPoint.getClass().getName();
            int startRange = BASE_MAPPER_PACKAGE_PREFIX.length();
            int endRange = targetClassName.indexOf(".", startRange);
            String dataSource = targetClassName.substring(startRange, endRange);
            DataSourceContentHolder.setCurrentDataSource(dataSource);
            joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            DataSourceContentHolder.clear();
        }
    }
}
