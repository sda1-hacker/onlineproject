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
 * @since 2020-11-24
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String account;

    @TableField("telNum")
    private String telnum;

    private String email;

    private String password;

    @TableField("realName")
    private String realname;

    /**
     * 0表示正常，1表示禁用
     */
    private Boolean status;

    @TableField("createTime")
    private LocalDateTime createtime;

    private String address;

    @TableField("nickName")
    private String nickname;

    public TUser(String account, String telnum, String email, String password, String realname, Boolean status, LocalDateTime createtime, String address, String nickname) {
        this.account = account;
        this.telnum = telnum;
        this.email = email;
        this.password = password;
        this.realname = realname;
        this.status = status;
        this.createtime = createtime;
        this.address = address;
        this.nickname = nickname;
    }
}
