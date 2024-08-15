package com.dingjiaxiong.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用戶信息dto
 *
 * @author: Ding Jiaxiong
 * @date: 2023/11/1
 */
@Data
public class AuthUserBO implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private String email;

    private String phone;

    private String password;

    private Integer sex;

    private String avatar;

    private Integer status;

    private String introduce;

    private String extJson;

}

