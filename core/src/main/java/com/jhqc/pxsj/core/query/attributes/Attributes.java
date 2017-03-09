package com.jhqc.pxsj.core.query.attributes;

import java.util.Date;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.exception.UnsupportedTypeException;
import com.jhqc.pxsj.core.query.root.Root;

public final class Attributes {
    private Attributes() {
        throw new AssertionError();
    }
    
    @SuppressWarnings("unchecked")
    public static <T,U> Attribute<T,U> generateAttribute(Root<?> root, Meta<T, U> meta) {
        if(String.class.isAssignableFrom(meta.getPropertyType())) {
            return (Attribute<T,U>)(new StringAttribute(root, (Meta<String, String>)meta));
        } if(Integer.class.isAssignableFrom(meta.getPropertyType())) {
            return (Attribute<T,U>)(new IntegerAttribute(root, (Meta<Integer, Number>)meta));
        } if(java.sql.Date.class.isAssignableFrom(meta.getPropertyType())) {
            return (Attribute<T,U>)(new DateAttribute(root, (Meta<java.sql.Date, Date>)meta));
        }else {
            throw new UnsupportedTypeException(meta.getPropertyType());
        }
    }
}
