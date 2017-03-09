package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.IntegerVariant;

public class IntegerAttribute extends IntegerVariant implements Attribute<Integer, Number> {

    public IntegerAttribute(Root<?> root, Meta<Integer, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }
}
