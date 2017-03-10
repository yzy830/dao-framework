package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.DoubleVariant;

public class DoubleAttribute extends DoubleVariant implements Attribute<Double, Number> {

    public DoubleAttribute(Root<?> root, Meta<Double, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

}
