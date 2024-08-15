package com.dingjiaxiong.auth.domain.service;


import com.dingjiaxiong.auth.domain.entity.AuthRoleBO;

/**
 * 角色领域service
 * 
 * @author: ChickenWing
 * @date: 2023/11/1
 */
public interface AuthRoleDomainService {


    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);


}
