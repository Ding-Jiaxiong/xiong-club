package com.dingjiaxiong.auth.domain.service;



import com.dingjiaxiong.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * 角色领域service
 * 
 * @author: Ding Jiaxiong
 * @date: 2023/11/1
 */
public interface AuthPermissionDomainService {


    Boolean add(AuthPermissionBO permissionBO);

    Boolean update(AuthPermissionBO permissionBO);


    Boolean delete(AuthPermissionBO permissionBO);

    List<String> getPermission(String userName);

}
