package com.dream.tea.provider.handler;

import com.dream.tea.provider.common.bean.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.dream.tea.service.common.bean.ResultCodeEnum.FIELD_NOT_VALID;

/**
 * @author yongfa
 */
@Slf4j
@Component
@ControllerAdvice(basePackages = "com.dream.tea.provider.controller")
public class ExceptionHandlerInterceptor {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public <T> RespResult<T> handler(HttpServletRequest request, HttpServletResponse response, BindException ex) {
        FieldError fieldError = ex.getFieldError();
        System.out.println(ex.toString());
        return RespResult.failed(FIELD_NOT_VALID.getCode(), fieldError.getDefaultMessage());
    }
}
