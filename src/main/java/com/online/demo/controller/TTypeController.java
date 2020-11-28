package com.online.demo.controller;


import com.online.demo.common.ResultBean;
import com.online.demo.entity.TType;
import com.online.demo.service.ITTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
@Controller
@RequestMapping("/type")
public class TTypeController {

    @Autowired
    private ITTypeService typeService;

    // 添加分类
    @PostMapping("addType")
    @ResponseBody
    public ResultBean<TType> addType(String typeName, int pid){

        TType type = typeService.addType(typeName, pid);

        if( type != null){
            ResultBean<TType> result = ResultBean.getSuccessInstance("分类添加成功..");
            result.setData(type);
            return result;
        }
        return null;
    }

    // 展示所有分类，在前台进行分层处理
    @GetMapping("showAllType")
    @ResponseBody
    public ResultBean<List<TType>> showAllType(int flag, HttpServletRequest request){

        List<TType> typeList = null;
        // 显示所有, 面向管理员
        if( 1 == flag){

            // if(request.getAttribute("admin") == null){
            //     return ResultBean.getErrorInstance("您无权访问该信息..");
            // }

            typeList = typeService.list();
        } else {
            typeList = typeService.showAllType();
        }

        if( typeList == null){
            return ResultBean.getErrorInstance("分类信息获取失败..");
        }

        ResultBean result = ResultBean.getSuccessInstance("分类信息获取成功..");
        result.setData(typeList);

        return result;
    }

    // 改变 type 状态
    public ResultBean<TType> changeTypeStatus(int id, HttpServletRequest request){

        // if(request.getAttribute("admin") == null){
        //     return ResultBean.getErrorInstance("您的权限不够..");
        // }

        TType type = typeService.getById(id);
        if( type == null){
            return ResultBean.getErrorInstance("类型信息不存在, 无法修改..");
        }

        int result = typeService.changeTypeStatus(!type.getStatus(), id);

        if( result > 0){
            return ResultBean.getSuccessInstance("分类信息状态改变成功..");
        }

        return ResultBean.getErrorInstance("分类信息状态改变失败..");
    }

}
