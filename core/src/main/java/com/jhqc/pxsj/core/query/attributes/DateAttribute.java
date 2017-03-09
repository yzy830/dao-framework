package com.jhqc.pxsj.core.query.attributes;

import java.sql.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.Root;
import com.jhqc.pxsj.core.query.variants.SqlDateVariant;

public class DateAttribute extends SqlDateVariant implements Attribute<Date, java.util.Date> {

    public DateAttribute(Root<?> root, Meta<Date> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
    }
}
