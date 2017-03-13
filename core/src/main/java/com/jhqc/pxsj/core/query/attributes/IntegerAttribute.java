package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.IntegerVariant;

class IntegerAttribute extends IntegerVariant implements Attribute<Integer, Number> {
    private Meta<Integer, Number> meta;
    
    public IntegerAttribute(Root<?> root, Meta<Integer, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }
}
