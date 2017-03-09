package com.jhqc.pxsj.core.query.attributes;

import java.util.Date;
import java.util.List;

import com.jhqc.pxsj.core.query.AstractAttribute;
import com.jhqc.pxsj.core.query.Operation;
import com.jhqc.pxsj.core.query.Predicate;
import com.jhqc.pxsj.core.query.Predicates;
import com.jhqc.pxsj.core.query.Root;

public class DateAttribute extends AstractAttribute<Date> {

    public DateAttribute(Root<?> root, String columnName) {
        super(root, columnName);
    }

    @Override
    public Predicate like(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Predicate equal(Date value) {
        return Predicates.singleParam(this, value, Operation.EQUAL);
    }

    @Override
    public Predicate notEqual(Date value) {
        return Predicates.singleParam(this, value, Operation.NOT_EQUAL);
    }

    @Override
    public Predicate gt(Date value) {
        return Predicates.singleParam(this, value, Operation.GT);
    }

    @Override
    public Predicate ge(Date value) {
        return Predicates.singleParam(this, value, Operation.GE);
    }

    @Override
    public Predicate lt(Date value) {
        return Predicates.singleParam(this, value, Operation.LT);
    }

    @Override
    public Predicate le(Date value) {
        return Predicates.singleParam(this, value, Operation.LE);
    }

    @Override
    public Predicate in(List<Date> values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Predicate isNull() {
        return Predicates.noParam(this, Operation.IS_NULL);
    }

    @Override
    public Predicate notNull() {
        return Predicates.noParam(this, Operation.IS_NOT_NULL);
    }
}
