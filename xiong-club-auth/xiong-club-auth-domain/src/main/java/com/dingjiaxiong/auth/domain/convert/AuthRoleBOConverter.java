package com.dingjiaxiong.auth.domain.convert;

import com.dingjiaxiong.auth.domain.entity.AuthRoleBO;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色bo转换器
 * 
 * @author: Ding Jiaxiong
 * @date: 2023/10/8
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

}
