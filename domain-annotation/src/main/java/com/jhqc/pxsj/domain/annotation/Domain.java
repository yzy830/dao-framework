package com.jhqc.pxsj.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Domain {
    /**
     * 领域模型的名字，默认情况下使用模型类的非限定全名
     */
    String name() default "";
    
    /**
     * 对应的数据库表。对于非默认数据库(pxsj)，需要使用schema.table_name的格式，例如pxsj_soa.t_d_order_base
     */
    String table();
}
