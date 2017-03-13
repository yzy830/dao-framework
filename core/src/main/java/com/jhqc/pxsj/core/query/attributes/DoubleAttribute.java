package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.DoubleVariant;

class DoubleAttribute extends DoubleVariant implements Attribute<Double, Number> {
    private Meta<Double, Number> meta;

    public DoubleAttribute(Root<?> root, Meta<Double, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }

}
