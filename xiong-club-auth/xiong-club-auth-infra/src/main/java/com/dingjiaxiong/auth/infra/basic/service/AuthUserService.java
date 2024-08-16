package com.dingjiaxiong.auth.infra.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthUser;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【auth_user(用户信息表)】的数据库操作Service
* @createDate 2024-08-14 22:06:37
*/
public interface AuthUserService extends IService<AuthUser> {

    List<AuthUser> queryByCondition(AuthUser existAuthUser);

    Integer updateByUserName(AuthUser authUser);

}
