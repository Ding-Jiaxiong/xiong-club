package com.dingjiaxiong.auth.infra.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dingjiaxiong.auth.infra.basic.entity.AuthUser;
import com.dingjiaxiong.auth.infra.basic.mapper.AuthUserMapper;
import com.dingjiaxiong.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author DingJiaxiong
 * @description 针对表【auth_user(用户信息表)】的数据库操作Service实现
 * @createDate 2024-08-14 22:06:37
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser>
        implements AuthUserService {

    @Resource
    private AuthUserMapper authUserMapper;

    @Override
    public List<AuthUser> queryByCondition(AuthUser existAuthUser) {
        return authUserMapper.queryAllByLimit(existAuthUser);
    }

    @Override
    public Integer updateByUserName(AuthUser authUser) {
        return authUserMapper.updateByUserName(authUser);
    }
}




