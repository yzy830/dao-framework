package com.jhqc.pxsj.core.query.attributes;

import java.util.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.DateVariant;

public class DateAttribute extends DateVariant implements Attribute<Date, Date> {
    private Meta<Date, Date> meta;

    public DateAttribute(Root<?> root, Meta<Date, Date> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }

}
