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
public class TType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 类型名称
     */
    @TableField("typeName")
    private String typename;

    /**
     * 父类型id
     */
    private Integer pid;

    /**
     * 当前类型的深度
     */
    private Integer deepth;

    /**
     * true表示可用，false表示隐藏不可以用
     */
    private Boolean status;

    @TableField("createTime")
    private LocalDateTime createtime;

    public TType(String typename, Integer pid, Integer deepth, Boolean status, LocalDateTime createtime) {
        this.typename = typename;
        this.pid = pid;
        this.deepth = deepth;
        this.status = status;
        this.createtime = createtime;
    }
}
