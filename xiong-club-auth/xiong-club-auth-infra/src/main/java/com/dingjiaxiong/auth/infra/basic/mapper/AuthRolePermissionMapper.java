package com.dingjiaxiong.auth.infra.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author DingJiaxiong
* @description 针对表【auth_role_permission(角色权限关联表)】的数据库操作Mapper
* @createDate 2024-08-14 22:06:37
* @Entity com.dingjiaxiong.auth.infra.basic.entity.AuthRolePermission
*/
public interface AuthRolePermissionMapper extends BaseMapper<AuthRolePermission> {

    int insertBatch(@Param("entities") List<AuthRolePermission> entities);

}




