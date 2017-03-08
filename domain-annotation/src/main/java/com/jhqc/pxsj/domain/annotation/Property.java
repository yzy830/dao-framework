package com.jhqc.pxsj.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Property {
    /**
     * 数据库列名，默认情况下，使用属性的下划线转换结果。例如goodsName -> goods_name
     */
    String value() default "";
}
