package com.dream.tea.provider.common.login.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yongfa
 */
@Slf4j
public abstract class ResponseHelper {

    /**
     * 返回文本数据
     *
     * @param response
     * @param text
     */
    public static void renderText(HttpServletResponse response, String text) {
        render(response, "text/plain;charset=UTF-8", text);
    }

    /**
     * 返回json数据
     *
     * @param response
     * @param text
     */
    public static void renderJson(HttpServletResponse response, String text) {
        render(response, "application/json;charset=UTF-8", text);
    }

    /**
     * 返回xml数据
     *
     * @param response
     * @param text
     */
    public static void renderXml(HttpServletResponse response, String text) {
        render(response, "text/xml;charset=UTF-8", text);
    }

    /**
     * 具体实现
     *
     * @param response
     * @param contentType
     * @param text
     */
    public static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
