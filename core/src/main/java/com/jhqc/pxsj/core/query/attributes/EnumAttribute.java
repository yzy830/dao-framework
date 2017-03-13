package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.EnumVariant;

class EnumAttribute<T extends Enum<T>> extends EnumVariant<T> implements Attribute<T, T> {
    private Meta<T, T> meta;

    public EnumAttribute(Root<?> root, Meta<T, T> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }

}
