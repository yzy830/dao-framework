package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.FloatVariant;

public class FloatAttribute extends FloatVariant implements Attribute<Float, Number> {

    public FloatAttribute(Root<?> root, Meta<Float, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

}
