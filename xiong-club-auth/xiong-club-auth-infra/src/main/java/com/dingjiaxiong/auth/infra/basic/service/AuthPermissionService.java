package com.dingjiaxiong.auth.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthPermission;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【auth_permission】的数据库操作Service
* @createDate 2024-08-14 22:06:37
*/
public interface AuthPermissionService extends IService<AuthPermission> {


    List<AuthPermission> queryByRoleList(List<Long> permissionIdList);

}
