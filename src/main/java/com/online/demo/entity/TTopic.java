package com.online.demo.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author sda1
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TTopic implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    /**
     * 话题创建时间
     */
    @TableField("createTime")
    private LocalDateTime createtime;

    /**
     * 话题的发布者id
     */
    private Integer uid;

    private Boolean status;

    /**
     * 热度
     */
    private Long heat;

    /**
     * 使用这个话题的人数
     */
    @TableField("referNum")
    private Integer refernum;

    public TTopic(String content, LocalDateTime createtime, Integer uid, Boolean status, Long heat, Integer refernum) {
        this.content = content;
        this.createtime = createtime;
        this.uid = uid;
        this.status = status;
        this.heat = heat;
        this.refernum = refernum;
    }
}
