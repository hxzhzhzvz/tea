package com.dream.tea.provider.common.interceptor;

import com.dream.tea.provider.common.login.interceptor.JwtUserAuthInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author yongfa
 */
@Component
public class MvcConfigurer implements WebMvcConfigurer {

    @Resource
    private JwtUserAuthInterceptor jwtUserAuthInterceptor;

    @Resource
    private AccessCountInterceptor accessCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessCountInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(jwtUserAuthInterceptor)
                .addPathPatterns("/**");
    }
}
