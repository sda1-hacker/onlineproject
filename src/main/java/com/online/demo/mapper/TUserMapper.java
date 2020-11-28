package com.online.demo.mapper;

import com.online.demo.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sda1
 * @since 2020-11-24
 */
public interface TUserMapper extends BaseMapper<TUser> {

    // 根据账号，电话，邮箱查找用户
    TUser findUserByAccountInfo(String accountInfo);
}
