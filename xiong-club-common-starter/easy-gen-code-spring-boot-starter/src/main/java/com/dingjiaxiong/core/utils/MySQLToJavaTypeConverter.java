package com.dingjiaxiong.core.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * mysql转java转换器
 *
 * @author loser
 * @date 2023/9/4
 */
public class MySQLToJavaTypeConverter {
    private static final Map<String, Item> typeMap = new HashMap<>();

    static {
        typeMap.put("tinyint", new Item(false, "Integer"));
        typeMap.put("smallint", new Item(false, "Short"));
        typeMap.put("mediumint", new Item(false, "Integer"));
        typeMap.put("int", new Item(false, "Integer"));
        typeMap.put("bigint", new Item(false, "Long"));
        typeMap.put("float", new Item(false, "Float"));
        typeMap.put("double", new Item(false, "Double"));
        typeMap.put("char", new Item(false, "String"));
        typeMap.put("varchar", new Item(false, "String"));
        typeMap.put("text", new Item(false, "String"));
        typeMap.put("longtext", new Item(false, "String"));
        typeMap.put("blob", new Item(false, "Byte"));
        typeMap.put("decimal", new Item(true, "BigDecimal"));
        typeMap.put("date", new Item(true, "Date"));
        typeMap.put("time", new Item(true, "Date"));
        typeMap.put("datetime", new Item(true, "Date"));
        typeMap.put("timestamp", new Item(true, "Date"));
    }

    public static Item convert(String mysqlType) {
        Item item = typeMap.get(mysqlType.toLowerCase());
        if (Objects.isNull(item)) {
            return new Item(false, mysqlType);
        }
        return item;
    }

    public static Item trans(String type) {
        for (Item value : typeMap.values()) {
            if (value.type.equals(type)) {
                return value;
            }
        }
        return new Item(false, type);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private boolean flag;
        private String type;
    }
}
