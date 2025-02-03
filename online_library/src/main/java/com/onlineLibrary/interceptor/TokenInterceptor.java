package com.onlineLibrary.interceptor;

import com.onlineLibrary.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 令牌校验的拦截器
 * 相较于过滤器而言 不用时不用注释掉@Component ，而是再配置类中处理
 */

@Component
public class TokenInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求头 token
        String token = request.getHeader("token");
        //判断token是否存在 不存在说明用户未登录 响应401(或者响应超时，请重新登录等)
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //如果纯在，校验token，校验失败，响应401
        try {
            JwtUtils.parseJwt(token);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        //校验通过
        return true;
    }
}
