package com.dingjiaxiong.core.utils;

/**
 * 判断是否是基本类型工具类
 *
 * @author loser
 * @date 2023/9/4
 */
public class PrimitiveTypeUtils {

    public static boolean isPrimitive(Object obj) {
        return obj instanceof Integer ||
                obj instanceof Long ||
                obj instanceof Float ||
                obj instanceof Double ||
                obj instanceof Boolean ||
                obj instanceof Character ||
                obj instanceof Byte;
    }

}
