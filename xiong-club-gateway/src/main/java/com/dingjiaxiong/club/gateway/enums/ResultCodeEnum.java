package com.dingjiaxiong.club.gateway.enums;

import lombok.Getter;

/**
 * code枚举
 * 
 * @author: Ding Jiaxiong
 * @date: 2023/10/28
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    public int code;

    public String desc;

    ResultCodeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
