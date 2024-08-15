package com.dingjiaxiong.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.dingjiaxiong.auth.common.enums.AuthUserStatusEnum;
import com.dingjiaxiong.auth.domain.constants.AuthConstant;
import com.dingjiaxiong.auth.domain.convert.AuthUserBOConverter;
import com.dingjiaxiong.auth.domain.entity.AuthUserBO;
import com.dingjiaxiong.auth.domain.redis.RedisUtil;
import com.dingjiaxiong.auth.domain.service.AuthUserDomainService;
import com.dingjiaxiong.auth.infra.basic.entity.*;
import com.dingjiaxiong.auth.infra.basic.service.*;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    private String salt = "xiongclub";

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";
    //
    private String authRolePrefix = "auth.role";

    @Override
    @SneakyThrows
    @Transactional
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);

        authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));

        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());

        boolean save = authUserService.save(authUser);

        // 建立一个初步的角色的关联，插入之后
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.queryByCondition(authRole);
        Long roleId = roleResult.getId();
        Long userId = authUser.getId();
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);

        authUserRoleService.insert(authUserRole);

        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new LinkedList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));

        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(roleId);
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.queryByCondition(authRolePermission);

        List<Long> permissionIdList = rolePermissionList.stream()
                .map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        //根据roleId查权限
        List<AuthPermission> permissionList = authPermissionService.queryByRoleList(permissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(permissionList));

        return save;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        boolean count = authUserService.updateById(authUser);
        return count;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        boolean count = authUserService.removeById(authUser);
        return count;
    }


}
