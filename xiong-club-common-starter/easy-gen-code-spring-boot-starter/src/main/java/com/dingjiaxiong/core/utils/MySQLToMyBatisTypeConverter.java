package com.dingjiaxiong.core.utils;

import java.util.HashMap;
import java.util.Map;

public class MySQLToMyBatisTypeConverter {
    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        // 添加MySQL数据类型到MyBatis数据类型的映射关系
        typeMap.put("VARCHAR", "VARCHAR");
        typeMap.put("CHAR", "CHAR");
        typeMap.put("TEXT", "VARCHAR");
        typeMap.put("LONGTEXT", "VARCHAR");
        typeMap.put("INT", "INTEGER");
        typeMap.put("TINYINT", "TINYINT");
        typeMap.put("SMALLINT", "SMALLINT");
        typeMap.put("MEDIUMINT", "INTEGER");
        typeMap.put("BIGINT", "BIGINT");
        typeMap.put("FLOAT", "REAL");
        typeMap.put("DOUBLE", "DOUBLE");
        typeMap.put("DECIMAL", "DECIMAL");
        typeMap.put("DATE", "DATE");
        typeMap.put("TIME", "TIME");
        typeMap.put("DATETIME", "TIMESTAMP");
        typeMap.put("TIMESTAMP", "TIMESTAMP");
        typeMap.put("YEAR", "DATE");
    }

    public static String convert(String mysqlType) {
        return typeMap.getOrDefault(mysqlType.toUpperCase(), "VARCHAR");
    }
}
