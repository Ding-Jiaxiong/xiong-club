package com.dingjiaxiong.auth.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRole;

/**
* @author DingJiaxiong
* @description 针对表【auth_role】的数据库操作Service
* @createDate 2024-08-14 22:06:37
*/
public interface AuthRoleService extends IService<AuthRole> {

    AuthRole queryByCondition(AuthRole authRole);

}
