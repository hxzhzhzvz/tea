package com.dream.tea.service.common.db.source;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yongfa
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.dream.tea.service.mapper.log", sqlSessionTemplateRef = "logSqlSessionTemplate")
public class LogDataSourceConfiguration {


    @Bean("log")
    @ConfigurationProperties(prefix = "spring.datasource.tea-log")
    public DataSource initTeaLogDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "logSqlSessionFactory")
    public SqlSessionFactory logSqlSessionFactory(@Qualifier("log") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/log/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "logTransactionManager")
    public DataSourceTransactionManager logTransactionManager(@Qualifier("log") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "logSqlSessionTemplate")
    public SqlSessionTemplate logSqlSessionTemplate(@Qualifier("logSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
