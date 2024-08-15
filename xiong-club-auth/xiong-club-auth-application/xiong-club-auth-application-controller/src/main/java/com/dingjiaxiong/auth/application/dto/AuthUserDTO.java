package com.dingjiaxiong.auth.application.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息dto
 * @TableName auth_user
 */

@Data
public class AuthUserDTO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名称/账号
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态 0启用 1禁用
     */
    private Integer status;

    /**
     * 个人介绍
     */
    private String introduce;

    /**
     * 特殊字段
     */
    private String extJson;

}