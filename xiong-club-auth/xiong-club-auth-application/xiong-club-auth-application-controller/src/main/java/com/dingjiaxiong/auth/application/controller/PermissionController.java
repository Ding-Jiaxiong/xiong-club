package com.dingjiaxiong.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.dingjiaxiong.auth.application.convert.AuthPermissionDTOConverter;
import com.dingjiaxiong.auth.application.dto.AuthPermissionDTO;
import com.dingjiaxiong.auth.common.entity.Result;
import com.dingjiaxiong.auth.domain.entity.AuthPermissionBO;
import com.dingjiaxiong.auth.domain.service.AuthPermissionDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 权限controller
 *
 * @author: Ding Jiaxiong
 * @date: 2023/11/2
 */
@RestController
@RequestMapping("/permission/")
@Slf4j
public class PermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    /**
     * 新增权限
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.add.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(authPermissionDTO.getName()), "权限名称不能为空");
            Preconditions.checkNotNull(authPermissionDTO.getParentId(), "权限父id不能为空");
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.add(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增权限失败");
        }
    }

    /**
     * 修改权限
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.update.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.update(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新权限信息失败");
        }
    }

    /**
     * 删除权限
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.delete.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.delete(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除权限信息失败");
        }
    }

    /**
     * 查询用户权限
     */
    @RequestMapping("getPermission")
    public Result<Boolean> getPermission(String userName) {
        try {
            log.info("PermissionController.getPermission.userName:{}",userName);
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "用户id不能为空");
            return Result.ok(authPermissionDomainService.getPermission(userName));
        } catch (Exception e) {
            log.error("PermissionController.getPermission.error:{}", e.getMessage(), e);
            return Result.fail("查询用户权限信息失败");
        }
    }

}
