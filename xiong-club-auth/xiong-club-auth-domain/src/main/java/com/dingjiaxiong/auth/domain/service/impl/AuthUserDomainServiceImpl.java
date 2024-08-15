package com.dingjiaxiong.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.dingjiaxiong.auth.common.enums.AuthUserStatusEnum;
import com.dingjiaxiong.auth.domain.convert.AuthUserBOConverter;
import com.dingjiaxiong.auth.domain.entity.AuthUserBO;
import com.dingjiaxiong.auth.domain.service.AuthUserDomainService;
import com.dingjiaxiong.auth.infra.basic.entity.AuthUser;
import com.dingjiaxiong.auth.infra.basic.service.AuthUserService;
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

    private String salt = "xiongclub";

    @Override
    @SneakyThrows
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);

        authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));

        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());

        boolean save = authUserService.save(authUser);

        // 建立一个初步的角色的关联

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
