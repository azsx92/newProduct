package com.frankit.product_v1.filter;

import com.frankit.product_v1.util.XssUtils;
import com.frankit.product_v1.wrapper.XssHttpServletRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.stream.Collectors;

public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 로직 (필요시 구현)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // JSON 요청인지 확인
        if ("application/json".equalsIgnoreCase(httpRequest.getContentType())) {
            // 요청 본문 읽기
            String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

            // XSS 방어 적용
            String cleanedJson = XssUtils.clean(json);

            // 새로운 HttpServletRequestWrapper로 래핑하여 본문 설정
            XssHttpServletRequestWrapper wrappedRequest = new XssHttpServletRequestWrapper(httpRequest, cleanedJson);
            chain.doFilter(wrappedRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // 소멸자 로직 (필요시 구현)
    }
}
