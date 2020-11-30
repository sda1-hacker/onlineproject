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
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long uid;

    private Double amount;

    @TableField("createTime")
    private LocalDateTime createtime;

    /**
     * 用户的网络ip
     */
    @TableField("userIp")
    private String userip;

    private String remarks;

    private String status;


}
