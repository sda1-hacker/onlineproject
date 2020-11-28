package com.online.demo.controller;


import com.online.demo.common.ResultBean;
import com.online.demo.entity.TTopic;
import com.online.demo.entity.TUser;
import com.online.demo.service.ITTopicService;
import com.online.demo.service.ITTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
@Controller
@RequestMapping("/topic")
public class TTopicController {

    @Autowired
    private ITTopicService topicService;

    @PostMapping("addTopic")
    public ResultBean<TTopic> addTopic(String content, HttpServletRequest request) {

        TUser currUser = (TUser) request.getAttribute("user");
        if( currUser == null){
            return ResultBean.getErrorInstance("没有登录, 不能添加topic..");
        }

        if(StringUtils.isEmpty(content)){
            return ResultBean.getErrorInstance("topic内容不能为空..");
        }

        TTopic topic = topicService.addTopic(content, currUser.getId());

        ResultBean<TTopic> result = ResultBean.getSuccessInstance("添加成功..");
        result.setData(topic);

        return result;
    }


}
