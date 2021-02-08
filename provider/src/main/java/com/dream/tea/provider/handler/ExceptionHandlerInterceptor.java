package com.dream.tea.provider.handler;

import cn.hutool.core.util.ObjectUtil;
import com.dream.tea.provider.common.bean.BaseResultCode;
import com.dream.tea.provider.common.bean.RespResult;
import com.dream.tea.service.common.bean.BusinessException;
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
    public <T> RespResult<T> handlerBindException(HttpServletRequest request, HttpServletResponse response, BindException ex) {
        // 处理表单验证异常
        FieldError fieldError = ex.getFieldError();
        if (ObjectUtil.isNotNull(fieldError)) {
            return RespResult.failed(FIELD_NOT_VALID.getCode(), fieldError.getDefaultMessage());
        } else {
            return RespResult.failed(BaseResultCode.SUCCESS_CODE, BaseResultCode.BASE_ERROR_MSG);
        }
    }

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public <T> RespResult<T> handlerBusinessException(HttpServletRequest request, HttpServletResponse response, BusinessException ex) {
        // 处理特定的业务异常，可以定制化返回错误提示
        return RespResult.failed(ex.getCode(), ex.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public <T> RespResult<T> handlerException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        // 全局拦截
        return RespResult.failed(BaseResultCode.BASE_ERROR_MSG);
    }
}
