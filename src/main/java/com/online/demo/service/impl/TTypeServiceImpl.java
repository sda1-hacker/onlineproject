package com.online.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.online.demo.common.ResultBean;
import com.online.demo.entity.TType;
import com.online.demo.mapper.TTypeMapper;
import com.online.demo.service.ITTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
@Service
public class TTypeServiceImpl extends ServiceImpl<TTypeMapper, TType> implements ITTypeService {

    @Resource
    private TTypeMapper typeMapper;

    @Override
    public TType addType(String typeName, int pid) {

        if( 0 == pid){
            TType type = new TType(typeName, pid, 1, true, null);
            return type;
        }
        TType ptype = typeMapper.selectById(pid);
        if( ptype != null){
            return null;
        }
        TType type = new TType(typeName, pid, ptype.getDeepth() + 1, true, null);

       return type;
    }

    // 展示所有的分类， status == true
    @Override
    public List<TType> showAllType() {

        QueryWrapper<TType> qw = new QueryWrapper();
        qw.eq("status", true);
        List<TType> typeList = typeMapper.selectList(qw);
        return typeList;
    }

    @Override
    public int changeTypeStatus(boolean flag, int id) {
        int result = typeMapper.changeTypeStatus(flag, id);
        return result;
    }
}
