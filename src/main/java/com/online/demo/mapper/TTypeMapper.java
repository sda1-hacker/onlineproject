package com.online.demo.mapper;

import com.online.demo.entity.TType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
public interface TTypeMapper extends BaseMapper<TType> {

    // 改变类型状态
    int changeTypeStatus(@Param("flag") boolean flag, @Param("id") int id);

}
