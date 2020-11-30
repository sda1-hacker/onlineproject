package com.online.demo.service.impl;

import com.online.demo.entity.TOrder;
import com.online.demo.mapper.TOrderMapper;
import com.online.demo.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sda1
 * @since 2020-11-30
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
