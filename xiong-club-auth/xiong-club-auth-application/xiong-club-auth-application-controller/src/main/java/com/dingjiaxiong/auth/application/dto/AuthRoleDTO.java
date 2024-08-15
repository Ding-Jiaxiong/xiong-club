package com.dingjiaxiong.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色dto
 *
 * @author: Ding Jiaxiong
 * @date: 2023/11/2
 */
@Data
public class AuthRoleDTO implements Serializable {

    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

