package com.dingjiaxiong.auth.domain.service.impl;

import com.dingjiaxiong.auth.domain.convert.AuthPermissionBOConverter;
import com.dingjiaxiong.auth.domain.entity.AuthPermissionBO;
import com.dingjiaxiong.auth.domain.service.AuthPermissionDomainService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthPermission;
import com.dingjiaxiong.auth.infra.basic.service.AuthPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;

    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        boolean count = authPermissionService.save(authPermission);
        return count;
    }

    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        boolean count = authPermissionService.updateById(authPermission);
        return count;
    }

    @Override
    public Boolean delete(AuthPermissionBO permissionBO) {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setId(permissionBO.getId());
        boolean count = authPermissionService.removeById(authPermission);
        return count;
    }


}
