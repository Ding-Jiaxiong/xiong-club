package com.dingjiaxiong.auth.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRolePermission;
import com.dingjiaxiong.auth.infra.basic.mapper.AuthRolePermissionMapper;
import com.dingjiaxiong.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

/**
* @author DingJiaxiong
* @description 针对表【auth_role_permission(角色权限关联表)】的数据库操作Service实现
* @createDate 2024-08-14 22:06:37
*/
@Service
public class AuthRolePermissionServiceImpl extends ServiceImpl<AuthRolePermissionMapper, AuthRolePermission>
    implements AuthRolePermissionService {

}




