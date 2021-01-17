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
@MapperScan(basePackages = "com.dream.tea.service.mapper.library", sqlSessionTemplateRef = "librarySqlSessionTemplate")
public class LibraryDataSourceConfiguration {


    @Bean("library")
    @ConfigurationProperties(prefix = "spring.datasource.tea-library")
    public DataSource initTeaLibraryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "librarySqlSessionFactory")
    public SqlSessionFactory librarySqlSessionFactory(@Qualifier("library") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/library/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "libraryTransactionManager")
    public DataSourceTransactionManager libraryTransactionManager(@Qualifier("library") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "librarySqlSessionTemplate")
    public SqlSessionTemplate librarySqlSessionTemplate(@Qualifier("librarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
