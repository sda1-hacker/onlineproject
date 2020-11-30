package com.online.demo.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author sda1
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TContent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private Long uid;

    @TableField("typeId")
    private Long typeid;

    private String content;

    @TableField("createTime")
    private LocalDateTime createtime;

    private Long views;

    private Long likes;


}
