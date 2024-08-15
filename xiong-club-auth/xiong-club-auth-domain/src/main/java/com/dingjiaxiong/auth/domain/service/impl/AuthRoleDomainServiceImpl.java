package com.dingjiaxiong.auth.domain.service.impl;

import com.dingjiaxiong.auth.common.enums.IsDeletedFlagEnum;
import com.dingjiaxiong.auth.domain.convert.AuthRoleBOConverter;
import com.dingjiaxiong.auth.domain.entity.AuthRoleBO;
import com.dingjiaxiong.auth.domain.service.AuthRoleDomainService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthRole;
import com.dingjiaxiong.auth.infra.basic.service.AuthRoleService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);

        boolean count = authRoleService.save(authRole);
        return count;
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        boolean count = authRoleService.updateById(authRole);
        return count;
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = new AuthRole();
        authRole.setId(authRoleBO.getId());
        boolean count = authRoleService.removeById(authRole);
        return count;
    }
}
