package com.online.demo.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /**
     * 0表示正常，1表示禁用
     */
    private Boolean status;

    @TableField("createTime")
    private LocalDateTime createtime;

    private String address;

    @TableField("nickName")
    private String nickname;

    private String gender;

    private int score;

    @TableField("userLevel")
    private String userlevel;

    @JsonIgnore
    @TableField("userType")
    private boolean usertype;

    public TUser(String account, String telnum, String email, String password, Boolean status, LocalDateTime createtime, String address, String nickname, String gender, int score, String userlevel) {
        this.account = account;
        this.telnum = telnum;
        this.email = email;
        this.password = password;
        this.status = status;
        this.createtime = createtime;
        this.address = address;
        this.nickname = nickname;
        this.gender = gender;
        this.score = score;
        this.userlevel = userlevel;
    }
}
