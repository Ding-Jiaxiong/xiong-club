package com.dingjiaxiong.auth.domain.service;


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
}

