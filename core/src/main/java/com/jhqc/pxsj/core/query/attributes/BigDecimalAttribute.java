package com.jhqc.pxsj.core.query.attributes;

import java.math.BigDecimal;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.BigDecimalVariant;

class BigDecimalAttribute extends BigDecimalVariant implements Attribute<BigDecimal, Number> {
    private Meta<BigDecimal, Number> meta;

    public BigDecimalAttribute(Root<?> root, Meta<BigDecimal, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }
}
