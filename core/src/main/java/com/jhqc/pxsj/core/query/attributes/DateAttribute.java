package com.jhqc.pxsj.core.query.attributes;

import java.util.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Root;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public class DateAttribute extends DateVariant {

    public DateAttribute(Root<?> root, Meta<Date> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }
}
