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
@Intercepts({@Signature(method = "update", type = Executor.class, args = {
        MappedStatement.class, Object.class
})})
public class MybatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        // 第1个参数为当前sql执行时填充的对象，可以是一个实体类，也可以是一个map，需要分情况处理
        Object parameters = invocation.getArgs()[1];
        if (parameters == null) {
            return invocation.proceed();
        }

        // 获取当前登录用户的id
        String loginId = LoginUtil.getLoginId();
        if (StringUtils.isBlank(loginId)) {
            return invocation.proceed();
        }
        if (Objects.equals(SqlCommandType.INSERT, sqlCommandType) || Objects.equals(SqlCommandType.UPDATE, sqlCommandType)) {
            replaceProperty(parameters, loginId, sqlCommandType);
        }
        return invocation.proceed();
    }

    private void replaceProperty(Object parameters, String loginId, SqlCommandType sqlCommandType) {
        if (parameters instanceof Map) {
            replaceMap((Map) parameters, loginId, sqlCommandType);
        } else {
            replace(parameters, loginId, sqlCommandType);
        }

    }

    private void replaceMap(Map parameters, String loginId, SqlCommandType sqlCommandType) {
        for (Object value : parameters.values()) {
            // 判断是否是一个List类，如果是的话需要遍历再做分别替换
            if (value instanceof List) {
                replaceList((List<?>) value, loginId, sqlCommandType);
            } else {
                replace(value, loginId, sqlCommandType);
            }
        }
    }

    private void replaceList(List<?> parameters, String loginId, SqlCommandType sqlCommandType) {
        for (Object o : parameters) {
            replace(o, loginId, sqlCommandType);
        }
    }

    private void replace(Object parameters, String loginId, SqlCommandType sqlCommandType) {
        if (Objects.equals(SqlCommandType.INSERT, sqlCommandType)) {
            replaceInsert(parameters, loginId);
        } else {
            replaceUpdate(parameters, loginId);
        }
    }

    private void replaceUpdate(Object parameters, String loginId) {
        Class<?> clazz = parameters.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object o = field.get(parameters);
                    if (Objects.nonNull(o)) {
                        field.setAccessible(false);
                        continue;
                    }
                    if ("updateBy".equals(field.getName())) {
                        field.set(parameters, loginId);
                        field.setAccessible(false);
                    } else if ("updateTime".equals(field.getName())) {
                        field.set(parameters, new Date());
                        field.setAccessible(false);
                    } else {
                        field.setAccessible(false);
                    }
                } catch (Exception e) {
                    log.error("replaceUpdate.error:{}", e.getMessage(), e);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    private void replaceInsert(Object parameters, String loginId) {
        Class<?> clazz = parameters.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object o = field.get(parameters);
                    if (Objects.nonNull(o)) {
                        field.setAccessible(false);
                        continue;
                    }
                    if ("isDeleted".equals(field.getName())) {
                        field.set(parameters, 0);
                        field.setAccessible(false);
                    } else if ("createdBy".equals(field.getName())) {
                        field.set(parameters, loginId);
                        field.setAccessible(false);
                    } else if ("createdTime".equals(field.getName())) {
                        field.set(parameters, new Date());
                        field.setAccessible(false);
                    } else {
                        field.setAccessible(false);
                    }
                } catch (Exception e) {
                    log.error("replaceInsert.error:{}", e.getMessage(), e);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}