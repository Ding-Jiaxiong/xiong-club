package com.dingjiaxiong.core.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.dingjiaxiong.core.core.sdk.Function;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class FunctionUtils implements Serializable {

    private static final Map<String, Function> functionMap = new ConcurrentHashMap<>();

    static {
        register(new Function() {
            @Override
            public String funcKey() {
                return "now()";
            }

            @Override
            public String doFunc() {
                return DateUtil.now();
            }
        });

        register(new Function() {
            @Override
            public String funcKey() {
                return "svUid()";
            }

            @Override
            public String doFunc() {
                try {
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
                    objectStream.writeObject(RandomUtil.randomBigDecimal());
                    objectStream.flush();
                    objectStream.close();

                    MessageDigest md5 = MessageDigest.getInstance("MD5");
                    byte[] byteArray = md5.digest(byteStream.toByteArray());
                    long serialVersionUID = 0L;
                    for (int i = Math.min(byteArray.length, 8) - 1; i >= 0; i--) {
                        serialVersionUID = (serialVersionUID << 8) | (byteArray[i] & 0xFF);
                    }
                    return Long.toString(serialVersionUID);
                } catch (Exception ignore) {
                }
                return null;
            }
        });

        register(new Function() {
            @Override
            public String funcKey() {
                return "date()";
            }

            @Override
            public String doFunc() {
                return DateUtil.formatDate(DateUtil.date());
            }
        });
    }


    public static boolean isFunction(Object funKey) {
        if (!(funKey instanceof String)) {
            return false;
        }
        return functionMap.containsKey(funKey);
    }

    public static void register(Function function) {
        functionMap.put(function.funcKey(), function);
    }

    public static Object doFunction(Object funKey) {
        if (!(funKey instanceof String)) {
            return funKey;
        }
        Function function = functionMap.get(funKey);
        if (Objects.isNull(function)) {
            return funKey;
        }
        return function.doFunc();
    }

}
