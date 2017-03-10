package com.jhqc.pxsj.core.query.attributes;

import java.math.BigDecimal;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;

@SuppressWarnings("rawtypes")
enum Generator implements AttributeGenerator {
    BIG_DECIMAL(BigDecimal.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new BigDecimalAttribute(root, meta);
        }
    },
    
    BOOLEAN(Boolean.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new BooleanAttribute(root, meta);
        }
    },
    
    DOUBLE(Double.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new DoubleAttribute(root, meta);
        }
    },
    
    ENUM(Enum.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new EnumAttribute(root, meta);
        }
    },
    
    FLOAT(Float.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new FloatAttribute(root, meta);
        }
        
    },
    
    INTEGER(Integer.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new IntegerAttribute(root, meta);
        }
    },
    
    LONG(Long.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new LongAttribute(root, meta);
        }
    },
    
    STRING(String.class) {

        @SuppressWarnings("unchecked")
        @Override
        public Attribute generate(Root root, Meta meta) {
            return new StringAttribute(root, meta);
        }
        
    }
    
    ;
    
    private Class<?> clazz;
    
    private Generator(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    private boolean match(Class<?> target) {
        return clazz.isAssignableFrom(target);
    }
    
    public static AttributeGenerator findMatch(Class<?> target) {
        for(Generator g : Generator.values()) {
            if(g.match(target)) {
                return g;
            }
        }
        
        return null;
    }
}
