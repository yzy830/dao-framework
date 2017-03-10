package com.jhqc.pxsj.core.query.variants;

import com.jhqc.pxsj.core.query.Operation;

abstract class NumberVariant<T extends Number, U> extends AbstractVariant<T, U> {

    public NumberVariant(Class<T> javaType, String exp) {
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
            return true;
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
