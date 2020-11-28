package com.online.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public String code;

    public T data;

    public String msg;

    public Date time;


    public static ResultBean getSuccessInstance(String msg){
        return new ResultBean("200", null, msg, new Date());
    }

    public static ResultBean getErrorInstance(String msg){
        return new ResultBean("500", null, msg, new Date());
    }
}
