package com.dingjiaxiong.core.entity;

import com.dingjiaxiong.core.utils.PrimitiveTypeUtils;
import lombok.Data;
import org.apache.velocity.VelocityContext;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义上下文
 *
 * @author loser
 * @date 2023/9/4
 */
@Data
public class Context implements Cloneable {

    private VelocityContext context = new VelocityContext();

    public VelocityContext get() {
        for (Map.Entry<String, Object> entry : contexts.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }
        return context;
    }

    private Map<String, Object> contexts = new ConcurrentHashMap<>();

    public void put(String key, Object obj) {
        contexts.put(key, obj);
    }

    public void remove(String key) {
        contexts.remove(key);
    }

    public void put(Object obj) {

        if (PrimitiveTypeUtils.isPrimitive(obj)) {
            return;
        }
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(obj);
                put(field.getName(), value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void removeObj(Object obj) {

        if (PrimitiveTypeUtils.isPrimitive(obj)) {
            return;
        }
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            remove(name);
        }

    }


    @Override
    public Context clone() {
        try {
            Context clone = (Context) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
