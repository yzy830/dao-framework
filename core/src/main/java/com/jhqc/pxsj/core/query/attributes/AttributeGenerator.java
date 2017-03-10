package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;

/**
 * 属性生成器
 *
 */
interface AttributeGenerator {
    Attribute<?,?> generate(Root<?> root, Meta<?, ?> meta);
}
