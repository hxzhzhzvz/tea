package com.dream.tea.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liyongfa
 */
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.*")
public class TeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeaApplication.class, args);
    }

}
