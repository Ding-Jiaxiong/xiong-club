package com.dingjiaxiong.club.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 *
 * @author: Ding Jiaxiong
 * @date: 2023/10/28
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    // 返回此 loginId 拥有的权限列表
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        LinkedList<String> permissionList = new LinkedList<>();
        permissionList.add("subject:add");
        return permissionList;
    }

    // 返回此 loginId 拥有的角色列表
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        LinkedList<String> roleList = new LinkedList<>();
        roleList.add("admin");
        return roleList;
    }

}
