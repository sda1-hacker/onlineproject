package com.online.demo.service;

import com.online.demo.entity.TType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
public interface ITTypeService extends IService<TType> {

    public TType addType(String typeName, int pid);

    public List<TType> showAllType();

    public int changeTypeStatus(boolean flag, int id);

}
