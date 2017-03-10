package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.BooleanVariant;

public class BooleanAttribute extends BooleanVariant implements Attribute<Boolean, Boolean> {

    public BooleanAttribute(Root<?> root, Meta<Boolean, Boolean> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

}
