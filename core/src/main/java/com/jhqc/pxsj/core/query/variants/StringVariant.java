package com.jhqc.pxsj.core.query.variants;

import com.jhqc.pxsj.core.query.Operation;

public class StringVariant extends AbstractVariant<String, String> {

    public StringVariant(Class<String> javaType, String exp) {
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
            return true;
        case IS_NOT_NULL:
            return true;
        case IS_NULL:
            return true;
        case LE:
            return false;
        case LIKE:
            return true;
        case LT:
            return false;
        case NOT_EQUAL:
            return true;
        default:
            return false;
        }
    }

}
