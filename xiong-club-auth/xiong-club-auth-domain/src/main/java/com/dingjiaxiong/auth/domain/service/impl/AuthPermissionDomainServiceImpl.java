package com.dingjiaxiong.auth.domain.service.impl;

import com.dingjiaxiong.auth.domain.convert.AuthPermissionBOConverter;
import com.dingjiaxiong.auth.domain.entity.AuthPermissionBO;
import com.dingjiaxiong.auth.domain.redis.RedisUtil;
import com.dingjiaxiong.auth.domain.service.AuthPermissionDomainService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthPermission;
import com.dingjiaxiong.auth.infra.basic.service.AuthPermissionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";

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

    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)) {
            return Collections.emptyList();
        }
        List<AuthPermission> permissionList = new Gson().fromJson(permissionValue,
                new TypeToken<List<AuthPermission>>() {
                }.getType());
        List<String> authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());

        return authList;
    }


}
