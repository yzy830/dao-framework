package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Root;
import com.jhqc.pxsj.core.query.variants.IntegerVariant;

public class IntegerAttribute extends IntegerVariant {

    public IntegerAttribute(Root<?> root, Meta<Integer> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }
}
