package com.sagalanov.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.sagalanov.constants.common.CommonConstants.RESULT_CACHE_HEADERS;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;

public class CacheInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader(CACHE_CONTROL, RESULT_CACHE_HEADERS);
        return super.preHandle(request, response, handler);
    }
}
