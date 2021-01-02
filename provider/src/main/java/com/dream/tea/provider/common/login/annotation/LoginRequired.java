package com.dream.tea.provider.common.login.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yongfa
 */
@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}
