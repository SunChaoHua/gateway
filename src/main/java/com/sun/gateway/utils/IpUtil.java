package com.sun.gateway.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;

public class IpUtil {

    public static String getIpAddress(ServerHttpRequest request) {
        String xIp = request.getHeaders().getFirst("X-Real-IP");
        String xFor = request.getHeaders().getFirst("X-Forwarded-For");
        if (StringUtils.isNotEmpty(xFor) && !"unKnown".equals(xFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xFor.indexOf(",");
            if (index != -1) {
                return xFor.substring(0, index);
            } else {
                return xFor;
            }
        }
        xFor = xIp;
        if (StringUtils.isNotEmpty(xFor) && !"unKnown".equals(xFor)) {
            return xFor;
        }
        if (StringUtils.isBlank(xFor) || !"unKnown".equals(xFor)) {
            xFor = request.getHeaders().getFirst("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xFor) || !"unKnown".equals(xFor)) {
            xFor = request.getHeaders().getFirst("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(xFor) || !"unKnown".equals(xFor)) {
            xFor = request.getHeaders().getFirst("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(xFor) || !"unKnown".equals(xFor)) {
            xFor = request.getHeaders().getFirst("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(xFor) || !"unKnown".equals(xFor)) {
            xFor = request.getRemoteAddress().getAddress().getHostAddress();
        }
        return xFor;
    }

}
