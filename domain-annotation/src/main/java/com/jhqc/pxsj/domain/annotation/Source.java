package com.jhqc.pxsj.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注一个结果集的数据来源。
 * (1) 如果在类上使用，那么这个类的所有属性均来自指定的root或者join，
 * (2) 如果在property上使用，可以覆盖这个属性的数据来源
 * 
 * 当使用selectAuto功能时，必须在结果集类上使用该标签。
 * 
 * 默认情况下，会查找领域模型中对应的属性，如果没有倒找，则会抛出{@link MismatchPropertyException}异常
 * 
 * 可以使用SourceProperty指定属性名，修改属性名
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Source {
    /**
     * root或者join的别名
     */
    String alias();
    
    /**
     * 数据来源领域模型 
     */
    Class<?> domain();
}
