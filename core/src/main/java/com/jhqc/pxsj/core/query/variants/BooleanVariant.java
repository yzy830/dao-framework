package com.jhqc.pxsj.core.query.variants;

import com.jhqc.pxsj.core.query.Operation;

public class BooleanVariant extends AbstractVariant<Boolean, Boolean> {

    public BooleanVariant(Class<Boolean> javaType, String exp) {
        super(javaType, exp);
    }

    @Override
    protected boolean support(Operation operation) {
        switch(operation) {
        case EQUAL:
            return true;
        case GE:
            return false;
        case GT:
            return false;
        case IN:
            return false;
        case IS_NOT_NULL:
            return true;
        case IS_NULL:
            return true;
        case LE:
            return false;
        case LIKE:
            return false;
        case LT:
            return false;
        case NOT_EQUAL:
            return true;
        default:
            return false;
        }
    }
}
