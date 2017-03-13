package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.StringVariant;

class StringAttribute extends StringVariant implements Attribute<String, String> {
    private Meta<String, String> meta;

    public StringAttribute(Root<?> root, Meta<String, String> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }

}
