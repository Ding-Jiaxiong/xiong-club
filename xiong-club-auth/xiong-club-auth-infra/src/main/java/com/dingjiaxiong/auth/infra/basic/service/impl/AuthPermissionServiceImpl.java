package com.dingjiaxiong.auth.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.auth.infra.basic.entity.AuthPermission;
import com.dingjiaxiong.auth.infra.basic.mapper.AuthPermissionMapper;
import com.dingjiaxiong.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

/**
* @author DingJiaxiong
* @description 针对表【auth_permission】的数据库操作Service实现
* @createDate 2024-08-14 22:06:37
*/
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission>
    implements AuthPermissionService {

}




