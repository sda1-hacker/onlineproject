package com.online.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.online.demo.common.CommonStr;
import com.online.demo.entity.TUser;
import com.online.demo.service.ITUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

    @Resource
    private ITUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @org.junit.Test
    public void qwTest(){

        QueryWrapper<TUser> qw = new QueryWrapper<>();
        qw.like("account", "root");
        TUser user = userService.getOne(qw);

        System.out.println(user);

    }

    @org.junit.Test
    public void zSetTest(){

        // redisTemplate.opsForZSet().add(CommonStr.HOT_TOPIC, "222", 100);
        // double res = redisTemplate.opsForZSet().score(CommonStr.HOT_TOPIC, "222"); // 不存在就报错
        // Long res = redisTemplate.opsForZSet().rank(CommonStr.HOT_TOPIC, "222"); // 不存在返回null，可以用来判断 某一个元素是否存在
        System.out.println(System.currentTimeMillis());
    }

}
