package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.FloatVariant;

class FloatAttribute extends FloatVariant implements Attribute<Float, Number> {
    private Meta<Float, Number> meta;

    public FloatAttribute(Root<?> root, Meta<Float, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }

}
