package com.qdu.bookstore.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        //获取session的token，不存在则直接拒绝访问。
        String sessionToken = (String) session.getAttribute("token");
        if (sessionToken == null){
            return false;
        }
        String requestToken = null;
        //获取并遍历前端的cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //如果带有token则取出，在下一步进行匹配验证
            if (cookie.getName().equals("token")) {
                requestToken = cookie.getValue();
                break;
            }
        }
        //如果和session中的token匹配，允许访问 否则拒绝
        if (requestToken != null&&requestToken.equals(sessionToken)) {
                return true;
        } else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
