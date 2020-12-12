package com.online.demo.service;

import com.online.demo.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sda1
 * @since 2020-11-24
 */
public interface ITUserService extends IService<TUser> {

    // 用户注册
    public int userRegist(TUser user);

    // 根据账号，手机号，邮箱 登录
    public TUser userLogin(String accountInfo, String password);

    // 判断用户是否登录
    public TUser checkUserIsLogin(String userToken);

    // 修改用户信息
    public TUser updateUserInfo(String userToken, String telnum,
                                String email, String password, String address,
                                String nickname);

}
