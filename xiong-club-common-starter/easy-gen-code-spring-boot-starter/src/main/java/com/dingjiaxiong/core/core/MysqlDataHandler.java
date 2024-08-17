package com.dingjiaxiong.core.core;

import cn.hutool.core.collection.CollectionUtil;
import com.dingjiaxiong.core.entity.JdbcConfig;
import com.dingjiaxiong.core.entity.TableInfo;
import com.dingjiaxiong.core.utils.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * 简易mysql处理器 查询表备注及表字段
 *
 * @author loser
 * @date 2023/9/4
 */
@AllArgsConstructor
public class MysqlDataHandler {

    private String tableName;
    private String dbUrl;
    private String dbUser;
    private String dbPw;
    private String dbName;
    private String driver;

    public String getTableComment() {
        JdbcConfig config = new JdbcConfig(
                dbUrl + dbName + "?useUnicode=true",
                dbUser,
                dbPw,
                dbName,
                driver,
                tableName
        );
        JdbcTemplate jdbcTemplate = initJdbcTemplate(config);
        String sql = "SELECT table_comment tableComment FROM information_schema.TABLES WHERE table_schema = ? and table_name = ? ";
        List<Object> params = Lists.newArrayList();
        params.add(config.getDbName());
        params.add(tableName);
        BeanPropertyRowMapper<TableInfo> rowMapper = new BeanPropertyRowMapper<>(TableInfo.class);
        if (CollectionUtil.isEmpty(params)) {
            return jdbcTemplate.query(sql, rowMapper).get(0).getTableComment();
        }
        List<TableInfo> query = jdbcTemplate.query(sql, rowMapper, params.toArray());
        if (CollectionUtil.isEmpty(query)) {
            throw new RuntimeException("表不存在：" + tableName);
        }
        return query.get(0).getTableComment();

    }


    /**
     * 使用表名 查询表结构信息
     */
    public List<TableInfo> searchByDb() {

        JdbcConfig config = new JdbcConfig(
                dbUrl + dbName + "?useUnicode=true",
                dbUser,
                dbPw,
                dbName,
                driver,
                tableName
        );
        JdbcTemplate jdbcTemplate = initJdbcTemplate(config);
        String sql = "select column_name as name, column_comment as comment,DATA_TYPE as dataType,COLUMN_KEY as keyType " +
                "from information_schema.columns where table_schema = ? and table_name = ? ORDER BY ORDINAL_POSITION";
        List<Object> params = Lists.newArrayList();

        params.add(config.getDbName());
        params.add(tableName);
        BeanPropertyRowMapper<TableInfo> rowMapper = new BeanPropertyRowMapper<>(TableInfo.class);
        if (CollectionUtil.isEmpty(params)) {
            return jdbcTemplate.query(sql, rowMapper);
        }
        List<TableInfo> list = jdbcTemplate.query(sql, rowMapper, params.toArray());
        return list.stream().peek(item -> {
            item.setCol(item.getName());
            item.setName(underlineToHump(item.getName()));
        }).collect(Collectors.toList());

    }


    /**
     * 初始化一个jdbc
     */
    private static JdbcTemplate initJdbcTemplate(JdbcConfig config) {
        DataSource dataSource;
        try {
            dataSource = new SimpleDriverDataSource(
                    BeanUtils.instantiateClass((Class<Driver>) Class.forName(config.getDriver())),
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new JdbcTemplate(dataSource);
    }

    private static Pattern UNDERLINE_PATTERN = Pattern.compile("_([a-z])");

    public static String underlineToHump(String str) {
        //正则匹配下划线及后一个字符，删除下划线并将匹配的字符转成大写
        Matcher matcher = UNDERLINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配的子串替换成指定字符串，并且将替换后的子串及之前到上次匹配的子串之后的字符串添加到StringBuffer对象中
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            //把之后的字符串也添加到StringBuffer对象中
            matcher.appendTail(sb);
        } else {
            //去除除字母之外的前面带的下划线
            return sb.toString().replaceAll("_", "");
        }
        return underlineToHump(sb.toString());
    }

}
