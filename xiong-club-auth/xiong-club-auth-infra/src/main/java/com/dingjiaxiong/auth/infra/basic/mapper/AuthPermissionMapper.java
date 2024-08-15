package com.dingjiaxiong.auth.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.auth.infra.basic.entity.AuthPermission;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【auth_permission】的数据库操作Mapper
* @createDate 2024-08-14 22:06:37
* @Entity com.dingjiaxiong.auth.infra.basic.entity.AuthPermission
*/
public interface AuthPermissionMapper extends BaseMapper<AuthPermission> {

    List<AuthPermission> queryByRoleList(List<Long> roleIdList);

}




