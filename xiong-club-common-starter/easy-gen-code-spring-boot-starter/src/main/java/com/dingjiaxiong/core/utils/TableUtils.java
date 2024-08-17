package com.dingjiaxiong.core.utils;

import com.dingjiaxiong.core.anno.Table;
import com.dingjiaxiong.core.entity.TableInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TableUtils {

    private TableUtils() {
    }

    public static String getComment(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        if (Objects.isNull(table)) {
            return "";
        }
        return table.value();
    }

    public static List<TableInfo> build(Class<?> clazz) {

        String comment = getComment(clazz);
        return Arrays.stream(clazz.getDeclaredFields()).filter(item -> {
            Table table = item.getAnnotation(Table.class);
            return Objects.nonNull(table);
        }).map(item -> {
            Table table = item.getAnnotation(Table.class);
            TableInfo info = new TableInfo();
            info.setKeyType(table.keyType());
            info.setCol(table.col());
            info.setTableComment(comment);
            info.setType(table.jdbcType());
            info.setMyBatisType(table.myBatisType());
            info.setName(item.getName());
            info.setComment(table.value());
            info.setDataType(item.getType().getSimpleName());
            return info;
        }).collect(Collectors.toList());

    }

}
