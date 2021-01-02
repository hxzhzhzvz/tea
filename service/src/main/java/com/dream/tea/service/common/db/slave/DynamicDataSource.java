package com.dream.tea.service.common.db.slave;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyongfa
 */
public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

    private static final Map<Object, Object> TARGET_DATASOURCE_MAP = new HashMap<>(8);

    @Override
    public void afterPropertiesSet() {
        this.setTargetDataSources(TARGET_DATASOURCE_MAP);
        super.afterPropertiesSet();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, DataSource> dataSourceMap = applicationContext.getBeansOfType(DataSource.class);
        TARGET_DATASOURCE_MAP.putAll(dataSourceMap);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContentHolder.getCurrentDataSource();
    }

}
