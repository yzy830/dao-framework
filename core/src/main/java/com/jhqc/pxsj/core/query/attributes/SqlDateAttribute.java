package com.jhqc.pxsj.core.query.attributes;

import java.sql.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.SqlDateVariant;

class SqlDateAttribute extends SqlDateVariant implements Attribute<Date, java.util.Date> {
    private Meta<Date, java.util.Date> meta;

    public SqlDateAttribute(Root<?> root, Meta<Date, java.util.Date> meta) {
        super(meta.getPropertyType(), AttributeUtil.genExp(root, meta));
        this.meta = meta;
    }

    @Override
    public String getAlias() {
        return meta.getName();
    }
}
