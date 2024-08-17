package com.dingjiaxiong.core.entity;

import cn.hutool.core.util.StrUtil;
import com.dingjiaxiong.core.utils.MySQLToJavaTypeConverter;
import com.dingjiaxiong.core.utils.MySQLToMyBatisTypeConverter;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 表信息
 *
 * @author loser
 * @date 2023/9/4
 */
@Data
public class TableInfo {

    // 字段索引类型
    private String keyType;
    private String col;
    private String name;
    private String upName;
    private String comment;
    private String dataType;
    private String tableComment;
    // 转化为java中的数据类型
    private String type;
    // 转为mybatis中的数据类型
    private String myBatisType;

    public String getMyBatisType() {
        if (StrUtil.isNotEmpty(myBatisType)) {
            return myBatisType;
        }
        return MySQLToMyBatisTypeConverter.convert(dataType);

    }

    public String getUpName() {
        return StrUtil.upperFirst(name);
    }

    public String getType() {
        if (StrUtil.isNotEmpty(type)) {
            return type;
        }
        return MySQLToJavaTypeConverter.convert(dataType).getType();
    }

    public MySQLToJavaTypeConverter.Item getTypeInfo() {
        return MySQLToJavaTypeConverter.convert(dataType);
    }

    public MySQLToJavaTypeConverter.Item getTypeInfo(String type) {
        return MySQLToJavaTypeConverter.trans(type);
    }

    public String getComment() {
        if (StringUtils.isEmpty(comment)) {
            return "";
        }
        return comment.trim().replace("\n" , "");
    }

}