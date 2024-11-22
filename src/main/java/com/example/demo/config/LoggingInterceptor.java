package com.example.demo.config;

import org.apache.logging.log4j.LogManager;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    Logger logger =  LogManager.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 打印请求日志
        Map<String, String> map = new HashMap<>();
        map.put("url", request.getRequestURI());
        map.put("method", request.getMethod());
        map.put("ip", request.getRemoteAddr());
        map.put("params", request.getParameterMap().toString());
        logger.info(map.toString());
        return true; // 返回true才会继续执行后续操作
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        // 可以根据需要打印日志或修改模型数据等

    }
}
