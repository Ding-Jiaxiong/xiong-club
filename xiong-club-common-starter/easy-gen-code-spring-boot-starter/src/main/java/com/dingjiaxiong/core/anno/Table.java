package com.dingjiaxiong.core.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    String value() default "";

    String keyType() default "";

    String col() default "";

    String comment() default "";

    String myBatisType() default "";

    String jdbcType() default "";

}
