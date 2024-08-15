package com.dingjiaxiong.auth.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRole;

/**
* @author DingJiaxiong
* @description 针对表【auth_role】的数据库操作Mapper
* @createDate 2024-08-14 22:06:37
* @Entity com.dingjiaxiong.auth.infra.basic.entity.AuthRole
*/
public interface AuthRoleMapper extends BaseMapper<AuthRole> {

    AuthRole queryAllByLimit(AuthRole authRole);

}




