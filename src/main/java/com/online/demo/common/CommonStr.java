package com.online.demo.common;

public class CommonStr {

    public static final String COOKIE_USER_TOKEN = "user_token"; // 返回给前端的cooke的名称

    public static final String REDIS_KEY = "userToken:";  // 与uuid组合的名称, 在redis中做key

    public static final String COOKIE_ADMIN_TOKEN = "admin_token";  // 返回给前端的cooke的名称 -- 管理员

    public static final String REDIS_KEY_ADMIN = "adminToken:";  // 与uuid组合的名称, 在redis中做key -- 管理员

    public static final String HOT_TOPIC = "hotTopic";  // 热门话题 -- redis 中 zset的key

    public static final String VIEW_NUM = "viewNum:";    // 浏览次数redis前缀    VIEW_NUM + id

    public static final String LIVE_NUM = "likeNum:";   // 点赞次数redis前缀      LIVE_NUM + id

    public static final String COLLECTION_CONTENT = "content"; // TContent 的solr 索引
}
