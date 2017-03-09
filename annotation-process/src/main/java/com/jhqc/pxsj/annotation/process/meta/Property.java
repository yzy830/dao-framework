package com.jhqc.pxsj.annotation.process.meta;

import java.beans.PropertyDescriptor;

import com.jhqc.pxsj.annotation.process.util.NameUtil;

public class Property<T> extends Meta<T> {

    public Property(PropertyDescriptor descriptor, com.jhqc.pxsj.domain.annotation.Property property) {
        super(descriptor);
        setColumnName(NameUtil.getPropertyColumnName(descriptor));
    }

}
