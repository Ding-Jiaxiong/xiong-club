package com.dingjiaxiong.auth.domain.service;


import cn.dev33.satoken.stp.SaTokenInfo;
import com.dingjiaxiong.auth.domain.entity.AuthUserBO;

import java.util.List;

/**
 * 用户领域service
 *
 * @author: Ding Jiaxiong
 * @date: 2023/11/1
 */
public interface AuthUserDomainService {


    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    Boolean delete(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);

    List<AuthUserBO> listUserInfoByIds(List<String> ids);
}

