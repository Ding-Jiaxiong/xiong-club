package com.dingjiaxiong.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限dto
 * 
 * @author: Ding Jiaxiong
 * @date: 2023/11/3
 */
@Data
public class AuthPermissionDTO implements Serializable {

    private Long id;
    
    private String name;
    
    private Long parentId;
    
    private Integer type;
    
    private String menuUrl;
    
    private Integer status;
    
    private Integer show;
    
    private String icon;
    
    private String permissionKey;
}

