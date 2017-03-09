package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Root;
import com.jhqc.pxsj.core.query.variants.StringVariant;

public class StringAttribute extends StringVariant {

    public StringAttribute(Root<?> root, Meta<String> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

}
