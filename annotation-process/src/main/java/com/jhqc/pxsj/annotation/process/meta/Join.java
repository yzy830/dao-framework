package com.jhqc.pxsj.annotation.process.meta;

import java.beans.PropertyDescriptor;

import com.jhqc.pxsj.annotation.process.util.NameUtil;

public class Join extends Meta {
    private Class<?> joinDomain;
    
    private String joinColumn;

    public Join(PropertyDescriptor descriptor, com.jhqc.pxsj.domain.annotation.Join join) {
        super(descriptor);
        setColumnName(NameUtil.getJoinColumnName(descriptor));
        joinDomain = join.domain();
        joinColumn = NameUtil.getTargetJoinColumName(join);
    }

    public Class<?> getJoinDomain() {
        return joinDomain;
    }

    public String getJoinColumn() {
        return joinColumn;
    }
}
