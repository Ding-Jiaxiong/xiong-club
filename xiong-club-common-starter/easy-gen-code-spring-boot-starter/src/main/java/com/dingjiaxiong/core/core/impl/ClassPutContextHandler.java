package com.dingjiaxiong.core.core.impl;

import com.dingjiaxiong.core.config.GenConfig;
import com.dingjiaxiong.core.config.MapperConfig;
import com.dingjiaxiong.core.core.sdk.PostCurFiledContextAware;
import com.dingjiaxiong.core.entity.TableInfo;
import com.dingjiaxiong.core.utils.TableUtils;
import org.apache.velocity.VelocityContext;

import java.util.List;

/**
 * 从字段注解中获取数据
 *
 * @author loser
 * @date 2023/9/4
 */
public class ClassPutContextHandler implements PostCurFiledContextAware {

    private Class<?> clazz;

    public ClassPutContextHandler(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void doAware(GenConfig genConfig, MapperConfig mapperConfig, VelocityContext context) {

        String tableComment = TableUtils.getComment(clazz);
        List<TableInfo> fields = TableUtils.build(clazz);
        context.put("tableComment", tableComment);
        context.put("fields", fields);

    }

}
