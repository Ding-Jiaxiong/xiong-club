package com.dingjiaxiong.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据库配置
 *
 * @author loser
 * @date 2023/9/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JdbcConfig {

    private String url;
    private String username;
    private String password;
    private String dbName;
    private String driver;
    private String tableName;

}