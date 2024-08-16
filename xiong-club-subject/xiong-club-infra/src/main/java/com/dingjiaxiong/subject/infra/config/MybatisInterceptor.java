package com.dingjiaxiong.subject.infra.config;

import com.dingjiaxiong.subject.common.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 填充createBy,createTime等公共字段的拦截器
 *
 * @author: Ding Jiaxiong
 * @date: 2024/1/5
 */
@Component
@Slf4j
@Intercepts({@Signature(type = Executor.class, method = "update", args = {
        MappedStatement.class, Object.class
})})
public class MybatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        Object parameter = invocation.getArgs()[1];
        if (parameter == null) {
            return invocation.proceed();
        }
        //获取当前登录用户的id
        String loginId = LoginUtil.getLoginId();
        if (StringUtils.isBlank(loginId)) {
            return invocation.proceed();
        }
        if (SqlCommandType.INSERT == sqlCommandType || SqlCommandType.UPDATE == sqlCommandType) {
            replaceEntityProperty(parameter, loginId, sqlCommandType);
        }
        return invocation.proceed();
    }

    private void replaceEntityProperty(Object parameter, String loginId, SqlCommandType sqlCommandType) {
        if (parameter instanceof Map) {
            replaceMap((Map) parameter, loginId, sqlCommandType);
        } else {
            replace(parameter, loginId, sqlCommandType);
        }
    }

    private void replaceMap(Map parameter, String loginId, SqlCommandType sqlCommandType) {
        for (Object val : parameter.values()) {
            replace(val, loginId, sqlCommandType);
        }
    }

    private void replace(Object parameter, String loginId, SqlCommandType sqlCommandType) {
        if (SqlCommandType.INSERT == sqlCommandType) {
            dealInsert(parameter, loginId);
        } else {
            dealUpdate(parameter, loginId);
        }
    }

    private void dealUpdate(Object parameter, String loginId) {
        Field[] fields = getAllFields(parameter);
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object o = field.get(parameter);
                if (Objects.nonNull(o)) {
                    field.setAccessible(false);
                    continue;
                }
                if ("updateBy".equals(field.getName())) {
                    field.set(parameter, loginId);
                    field.setAccessible(false);
                } else if ("updateTime".equals(field.getName())) {
                    field.set(parameter, new Date());
                    field.setAccessible(false);
                } else {
                    field.setAccessible(false);
                }
            } catch (Exception e) {
                log.error("dealUpdate.error:{}", e.getMessage(), e);
            }
        }
    }

    private void dealInsert(Object parameter, String loginId) {
        Field[] fields = getAllFields(parameter);
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object o = field.get(parameter);
                if (Objects.nonNull(o)) {
                    field.setAccessible(false);
                    continue;
                }
                if ("isDeleted".equals(field.getName())) {
                    field.set(parameter, 0);
                    field.setAccessible(false);
                } else if ("createdBy".equals(field.getName())) {
                    field.set(parameter, loginId);
                    field.setAccessible(false);
                } else if ("createdTime".equals(field.getName())) {
                    field.set(parameter, new Date());
                    field.setAccessible(false);
                } else {
                    field.setAccessible(false);
                }
            } catch (Exception e) {
                log.error("dealInsert.error:{}", e.getMessage(), e);
            }
        }
    }

    private Field[] getAllFields(Object object) {
        Class<?> clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
