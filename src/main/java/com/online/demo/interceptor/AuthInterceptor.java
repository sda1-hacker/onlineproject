package com.online.demo.interceptor;

import com.online.demo.common.CommonStr;
import com.online.demo.entity.TUser;
import com.online.demo.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登录拦截
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private ITUserService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        if(cookies == null){
            return true;
        }

        for (Cookie cookie : cookies){

            // TODO admin相关过滤在这里处理

            if(CommonStr.COOKIE_USER_TOKEN.equals(cookie.getName())) {
                TUser currUser = userService.checkUserIsLogin(cookie.getValue()); // userService注入失败 -- 需要生成一个AuthIntercepter的Bean对象交给Spring管理才可以
                if(currUser != null){
                    request.setAttribute("user", currUser);
                    return true;
                }
            }
        }
        return true;
    }

}
