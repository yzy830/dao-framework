package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.Variant;

/**
 * 生成变量的函数接口
 *
 * @param <X>
 *          属性的java类型
 * @param <Y>
 *          属性的兼容类型
 */
@FunctionalInterface
public interface VariantGenerator<X, Y> {
    Variant<? extends Y, ?> generate(Root<?> root, Meta<X, Y> property);
}
