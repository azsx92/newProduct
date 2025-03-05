package com.frankit.product_v1.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class CommonHttpRequestInterceptor implements HandlerInterceptor {
    public static final String HEADER_REQUEST_UUID_KEY = "x-request-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestEventId = request.getHeader(HEADER_REQUEST_UUID_KEY);
        if (ObjectUtils.isEmpty(requestEventId)) {
            requestEventId = UUID.randomUUID().toString();
        }

        MDC.put(HEADER_REQUEST_UUID_KEY, requestEventId);
        return true;
    }
}
