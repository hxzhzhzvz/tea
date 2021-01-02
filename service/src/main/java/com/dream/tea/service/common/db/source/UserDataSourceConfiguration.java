package com.dream.tea.service.common.db.source;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
@MapperScan(basePackages = "com.dream.tea.service.mapper.user", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class UserDataSourceConfiguration {

    @Value("${spring.datasource.tea-user.jdbcUrl}")
    private String jdbcUrl;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Bean("user")
    @ConfigurationProperties(prefix = "spring.datasource.tea-user")
    public DataSource initTeaUserDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("user") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/user/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("user") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
