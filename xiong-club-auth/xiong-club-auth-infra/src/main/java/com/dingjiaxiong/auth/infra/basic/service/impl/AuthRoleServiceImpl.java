package com.dingjiaxiong.auth.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRole;
import com.dingjiaxiong.auth.infra.basic.mapper.AuthRoleMapper;
import com.dingjiaxiong.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

/**
* @author DingJiaxiong
* @description 针对表【auth_role】的数据库操作Service实现
* @createDate 2024-08-14 22:06:37
*/
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole>
    implements AuthRoleService {

}




