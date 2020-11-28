package com.online.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.online.demo.common.CommonStr;
import com.online.demo.entity.TTopic;
import com.online.demo.mapper.TTopicMapper;
import com.online.demo.service.ITTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.online.demo.utils.TimeUtils;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
@Slf4j
@Service
public class TTopicServiceImpl extends ServiceImpl<TTopicMapper, TTopic> implements ITTopicService {

    @Resource
    private TTopicMapper topicMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    // 添加话题
    @Override
    public TTopic addTopic(String content, int uid) {

        Long rank = redisTemplate.opsForZSet().rank(CommonStr.HOT_TOPIC, content);
        Long second = TimeUtils.getTimeForTimestamp(LocalDateTime.now());
        Long socre = second;

        // 查询条件
        QueryWrapper<TTopic> qw = new QueryWrapper<>();
        qw.eq("content", content);

        // 话题的热度： 当前天的时间戳  +  参与人数*100
        // content不存在的时候， 返回null
        if( rank == null){
            TTopic topic = topicMapper.selectOne(qw);
            // 不在mysql中
            if(topic ==null) {
                redisTemplate.opsForZSet().add(CommonStr.HOT_TOPIC, content, 1d * socre);
                TTopic topicTmp = new TTopic(content, LocalDateTime.now(), uid, true, socre, 1);
                topicMapper.insert(topicTmp);
                return topicTmp;
            }
            redisTemplate.opsForZSet().add(CommonStr.HOT_TOPIC, content, 1d * TimeUtils.getTimeForTimestamp(topic.getCreatetime()));
            return topic;
        }

        TTopic topic = topicMapper.selectOne(qw);
        return topic;
    }

}
