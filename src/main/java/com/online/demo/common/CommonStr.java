package com.online.demo.common;

public class CommonStr {

    public static final String COOKIE_USER_TOKEN = "user_token"; // 返回给前端的cooke的名称

    public static final String REDIS_KEY = "userToken:";  // 与uuid组合的名称, 在redis中做key

    // 管理员 token
    public static final String COOKIE_ADMIN_TOKEN = "admin_token";  // 返回给前端的cooke的名称

    public static final String REDIS_KEY_ADMIN = "adminToken:";  // 与uuid组合的名称, 在redis中做key

    public static final String HOT_TOPIC = "hotTopic";  // 热门话题

}
