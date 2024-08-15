package com.dingjiaxiong.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (AuthRolePermission)实体类
 *
 * @author makejava
 * @since 2023-11-04 22:16:00
 */
@Data
public class AuthRolePermissionBO implements Serializable {
    private static final long serialVersionUID = 459343371709166261L;
    
    private Long id;
    
    private Long roleId;
    
    private Long permissionId;

    private List<Long> permissionIdList;
}

