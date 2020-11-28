package com.online.demo.service;

import com.online.demo.entity.TTopic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
public interface ITTopicService extends IService<TTopic> {

    public TTopic addTopic(String content, int uid);

}
