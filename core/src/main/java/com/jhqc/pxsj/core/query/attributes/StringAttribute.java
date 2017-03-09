package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.StringVariant;

public class StringAttribute extends StringVariant implements Attribute<String, String> {

    public StringAttribute(Root<?> root, Meta<String, String> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }

}
