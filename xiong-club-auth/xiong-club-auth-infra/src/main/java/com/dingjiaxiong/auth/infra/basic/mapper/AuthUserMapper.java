package com.dingjiaxiong.auth.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.auth.infra.basic.entity.AuthUser;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【auth_user(用户信息表)】的数据库操作Mapper
* @createDate 2024-08-14 22:06:37
* @Entity com.dingjiaxiong.auth.infra.basic.entity.AuthUser
*/
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    List<AuthUser> queryAllByLimit(AuthUser existAuthUser);

    Integer updateByUserName(AuthUser authUser);

}




