package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.BooleanVariant;

class BooleanAttribute extends BooleanVariant implements Attribute<Boolean, Boolean> {
    Meta<Boolean, Boolean> meta;

    public BooleanAttribute(Root<?> root, Meta<Boolean, Boolean> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }

}
