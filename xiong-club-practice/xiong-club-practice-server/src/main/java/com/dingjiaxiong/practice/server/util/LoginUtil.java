package com.dingjiaxiong.practice.server.util;


import com.dingjiaxiong.practice.server.config.context.LoginContextHolder;

/**
 * 用户登录util
 *
 * @author: Ding Jiaxiong
 * @date: 2023/11/26
 */
public class LoginUtil {

    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }


}