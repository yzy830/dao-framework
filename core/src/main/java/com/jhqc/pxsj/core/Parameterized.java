package com.jhqc.pxsj.core;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;

/**
 * 表示一个表达式具有参数，例如ParamterizedVariant、Setting等都可以具有参数
 * 
 * @author Administrator
 *
 */
public interface Parameterized {
    List<? extends Parameter<?>> getParams();
}
