package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.LongVariant;

public class LongAttribute extends LongVariant implements Attribute<Long, Number> {

    public LongAttribute(Root<?> root, Meta<Long, Number> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

}
