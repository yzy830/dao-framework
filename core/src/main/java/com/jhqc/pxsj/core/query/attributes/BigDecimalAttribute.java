package com.jhqc.pxsj.core.query.attributes;

import java.math.BigDecimal;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.BigDecimalVariant;

public class BigDecimalAttribute extends BigDecimalVariant implements Attribute<BigDecimal, Number> {

    public BigDecimalAttribute(Root<?> root, Meta<BigDecimal, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }
}
