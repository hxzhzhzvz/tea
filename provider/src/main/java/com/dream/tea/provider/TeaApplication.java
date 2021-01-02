package com.dream.tea.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liyongfa
 */
@MapperScan(basePackages = "com.dream.tea.service.mapper.user")
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.*")
public class TeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaApplication.class, args);
    }

}
