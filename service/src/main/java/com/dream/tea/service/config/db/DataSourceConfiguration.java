package com.dream.tea.service.config.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author liyongfa
 */
@Configuration
public class DataSourceConfiguration {

    @Bean("user")
    @ConfigurationProperties(prefix = "spring.datasource.tea-user")
    public DataSource initTeaUserDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("config")
    @ConfigurationProperties(prefix = "spring.datasource.tea-config")
    public DataSource initTeaConfigDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("course")
    @ConfigurationProperties(prefix = "spring.datasource.tea-course")
    public DataSource initTeaCourseDataSource() {
        return DataSourceBuilder.create().build();
    }
}
