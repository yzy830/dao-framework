package com.jhqc.pxsj.core.query.variants;

import java.util.Date;

import com.jhqc.pxsj.core.query.Operation;

public abstract class DateAbstractVariant<T extends Date, U extends Date> extends AbstractVariant<T, U> {

    public DateAbstractVariant(Class<T> javaType, String exp) {
        super(javaType, exp);
    }
    
    @Override
    protected boolean support(Operation operation) {
        switch(operation) {
        case EQUAL:
            return true;
        case GE:
            return true;
        case GT:
            return true;
        case IN:
            return false;
        case IS_NOT_NULL:
            return true;
        case IS_NULL:
            return true;
        case LE:
            return true;
        case LIKE:
            return false;
        case LT:
            return true;
        case NOT_EQUAL:
            return true;
        default:
            return false;
        }
    }
}
