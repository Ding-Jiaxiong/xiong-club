package com.dingjiaxiong.subject.common.util;


import com.dingjiaxiong.subject.common.context.LoginContextHolder;

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
