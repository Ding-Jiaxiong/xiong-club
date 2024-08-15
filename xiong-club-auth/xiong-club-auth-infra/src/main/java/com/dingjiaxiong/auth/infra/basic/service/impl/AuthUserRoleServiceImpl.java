package com.dingjiaxiong.auth.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.auth.infra.basic.entity.AuthUserRole;
import com.dingjiaxiong.auth.infra.basic.mapper.AuthUserRoleMapper;
import com.dingjiaxiong.auth.infra.basic.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author DingJiaxiong
 * @description 针对表【auth_user_role(用户角色表)】的数据库操作Service实现
 * @createDate 2024-08-14 22:06:37
 */
@Service
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleMapper, AuthUserRole>
        implements AuthUserRoleService {

    @Resource
    private AuthUserRoleMapper authUserRoleMapper;

    @Override
    public AuthUserRole insert(AuthUserRole authUserRole) {
        authUserRoleMapper.insert(authUserRole);
        return authUserRole;
    }
}




