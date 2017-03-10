package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.exception.UnsupportedTypeException;
import com.jhqc.pxsj.core.query.root.Root;

public final class Attributes {
    private Attributes() {
        throw new AssertionError();
    }
    
    @SuppressWarnings("unchecked")
    public static <T,U> Attribute<T,U> generateAttribute(Root<?> root, Meta<T, U> meta) {        
        AttributeGenerator generator = AttributeRegister.findMatch(meta.getPropertyType());
        
        if(generator == null) {
            throw new UnsupportedTypeException(meta.getPropertyType());
        }
        
        return (Attribute<T,U>)(generator.generate(root, meta));
    }
}
