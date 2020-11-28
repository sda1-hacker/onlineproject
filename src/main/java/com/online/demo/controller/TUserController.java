package com.online.demo.controller;


import com.online.demo.common.CommonStr;
import com.online.demo.common.ResultBean;
import com.online.demo.entity.TUser;
import com.online.demo.service.ITUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sda1
 * @since 2020-11-24
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class TUserController {
    @Autowired
    private ITUserService userService;
    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("userRegist")
    @ResponseBody
    public ResultBean<TUser> userRegist(String account, String telNum, String email, String password ,
                             String realName, String province, String area, String address, String nickName){

        StringBuilder addr = new StringBuilder(province).append(area).append(address);

        TUser user = new TUser(account,telNum, email, password, realName, true, null, addr.toString(), nickName);
        userService.userRegist(user);

        return ResultBean.getSuccessInstance("注册成功..");
    }


    // 用户登录
    @PostMapping("userLogin")
    @ResponseBody
    public ResultBean<TUser> userLogin( String accountInfo, String password, HttpServletRequest request, HttpServletResponse response){

        TUser user = userService.userLogin(accountInfo, password);

        if(user == null){
            return ResultBean.getErrorInstance("用户不存在..");
        }

        // 构造 cookie
        String userToken = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(CommonStr.COOKIE_USER_TOKEN, userToken);
        cookie.setMaxAge(30); // cookie存活时间
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        // redis中存储信息
        StringBuilder redisKey = new StringBuilder(CommonStr.REDIS_KEY).append(userToken);
        redisTemplate.opsForValue().set(redisKey.toString(), user);
        redisTemplate.expire(redisKey.toString(), 30, TimeUnit.MINUTES);

        // 将cookie返回给前端
        response.addCookie(cookie);

        ResultBean<TUser> result = ResultBean.getSuccessInstance("登录成功..");
        result.setData(user);

        return result;
    }


    @GetMapping("showUserInfo")
    @ResponseBody
    public ResultBean<TUser> showUserInfo(HttpServletRequest request, Model model){
        TUser currUser = (TUser) request.getAttribute("user");

        if(currUser == null){
            return ResultBean.getErrorInstance("您还没有登录, 不能查看个人信息..");
        }

        ResultBean<TUser> result = ResultBean.getSuccessInstance("已为您显示个人信息..");
        result.setData(currUser);
        return result;
    }


    @GetMapping("updateUserInfo")
    @ResponseBody
    public ResultBean<TUser> updateUserInfo(HttpServletRequest request){

        TUser currUser = (TUser) request.getAttribute("user");

        if(currUser == null){
            return ResultBean.getErrorInstance("您还没有登录,不能修改信息..");
        }

        // TODO 修改用户信息逻辑

        request.setAttribute("user", currUser);
        ResultBean<TUser> result = ResultBean.getSuccessInstance("修改成功..");
        result.setData(currUser);

        return result;
    }


    @ResponseBody
    @GetMapping("userLogout")
    public ResultBean<TUser> userLogout(@CookieValue(CommonStr.COOKIE_USER_TOKEN) String userToken,
                                        HttpServletRequest request, HttpServletResponse response){
        TUser currUser = (TUser) request.getAttribute("user");

        if(currUser == null){
            return ResultBean.getErrorInstance("您还没有登录, 不能进行注销操作..");
        }

        Cookie cookie = new Cookie(CommonStr.COOKIE_USER_TOKEN, "");
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        StringBuilder redisKey = new StringBuilder(CommonStr.REDIS_KEY).append(userToken);
        redisTemplate.delete(redisKey.toString());

        log.info("logout info{}", "注销成功~");
        return ResultBean.getSuccessInstance("注销成功");
    }
}
