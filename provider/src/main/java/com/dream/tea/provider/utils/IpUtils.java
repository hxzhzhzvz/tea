package com.dream.tea.provider.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yongfa
 */
public class IpUtils {

    private static final String UN_KNOWN = "unknown";

    private static final String LOCAL_HOST = "127.0.0.1";

    private static final String COMMA = ",";

    /**
     * 从http请求中获取到ip地址
     *
     * @param request 请求对象
     * @return 返回的ip地址，解析失败返回null
     */
    public static String getIpAddr(HttpServletRequest request) {
        try {
            String ipAddress = request.getHeader("x-forwarded-for");
            if (StringUtils.isBlank(ipAddress) || UN_KNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isBlank(ipAddress) || UN_KNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isBlank(ipAddress) || UN_KNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals(LOCAL_HOST)) {
                    try {
                        InetAddress inet = InetAddress.getLocalHost();
                        ipAddress = inet.getHostAddress();
                    } catch (UnknownHostException e) {
                        return null;
                    }
                }
            }
            int fifteen = 15;
            if (StringUtils.isNotBlank(ipAddress) && ipAddress.length() > fifteen) {
                if (ipAddress.indexOf(COMMA) > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(COMMA));
                }
            }
            return ipAddress;
        } catch (Exception e) {
            return null;
        }
    }
}
