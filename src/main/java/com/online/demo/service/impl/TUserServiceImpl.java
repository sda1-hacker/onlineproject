package com.online.demo.service.impl;

import com.online.demo.common.CommonStr;
import com.online.demo.entity.TUser;
import com.online.demo.mapper.TUserMapper;
import com.online.demo.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sda1
 * @since 2020-11-24
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 用户注册
    @Override
    public int userRegist(TUser user) {

        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        int res = userMapper.insert(user);
        return res;

    }

    // 用户登录
    @Override
    public TUser userLogin(String accountInfo, String password) {

        TUser user = userMapper.findUserByAccountInfo(accountInfo);

        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            return user;
        }

        return null;
    }

    // 检查用户是否登录
    @Override
    public TUser checkUserIsLogin(String userToken) {

        if("".equals(userToken) || userToken == null) {
            return null;
        }

        StringBuilder redisKey = new StringBuilder(CommonStr.REDIS_KEY).append(userToken);
        TUser currUser = (TUser) redisTemplate.opsForValue().get(redisKey.toString());

        if(currUser != null){
            redisTemplate.expire(redisKey.toString(), 30, TimeUnit.MINUTES);
            return currUser;
        }

        return null;
    }
}
