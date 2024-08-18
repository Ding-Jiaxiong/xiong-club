package com.dingjiaxiong.auth.api;
import com.dingjiaxiong.auth.entity.AuthUserDTO;
import com.dingjiaxiong.auth.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户服务feign
 *
 * @author: Ding Jiaxiong
 * @date: 2023/12/3
 */
@FeignClient("xiong-club-auth-dev")
public interface UserFeignService {

    @RequestMapping("/user/getUserInfo")
    Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO);

    @RequestMapping("/user/listByIds")
    Result<List<AuthUserDTO>> listUserInfoByIds(@RequestBody List<String> userNameList);

}
