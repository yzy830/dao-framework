package com.jhqc.pxsj.core.query.variants;

import java.util.Arrays;
import java.util.List;

import com.jhqc.pxsj.core.query.Operation;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.predicate.Predicates;

public abstract class AbstractVariant<T, U> implements Variant<T, U> {
    
    private Class<T> javaType;
    
    private String exp;
    
    public AbstractVariant(Class<T> javaType, String exp) {
        this.javaType = javaType;
        this.exp = exp;
    }

    @Override
    public String getExp() {
        return exp;
    }
    
    public SelectingVariant<T> as(String alias) {
        return new SelectingVariantImpl<>(this, alias);
    }

    @Override
    public Class<T> getJavaType() {
        return javaType;
    }
    
    protected abstract boolean support(Operation operation);
    
    private void checkSupport(Operation operation) {
        if(!support(operation)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Predicate like(T value) {
        checkSupport(Operation.LIKE);
        
        return Predicates.singleParam(this, value, Operation.LIKE);
    }

    @Override
    public Predicate eq(T value) {
        checkSupport(Operation.EQUAL);
        
        return Predicates.singleParam(this, value, Operation.EQUAL);
    }

    @Override
    public Predicate notEq(T value) {
        checkSupport(Operation.NOT_EQUAL);
        
        return Predicates.singleParam(this, value, Operation.NOT_EQUAL);
    }

    @Override
    public Predicate gt(T value) {
        checkSupport(Operation.GT);
        
        return Predicates.singleParam(this, value, Operation.GT);
    }

    @Override
    public Predicate ge(T value) {
        checkSupport(Operation.GE);
        
        return Predicates.singleParam(this, value, Operation.GE);
    }

    @Override
    public Predicate lt(T value) {
        checkSupport(Operation.LT);
        
        return Predicates.singleParam(this, value, Operation.LT);
    }

    @Override
    public Predicate le(T value) {
        checkSupport(Operation.LE);
        
        return Predicates.singleParam(this, value, Operation.LE);
    }

    @Override
    public Predicate in(T[] values) {
        checkSupport(Operation.IN);
        
        return Predicates.multipleParam(this, Arrays.asList(values), Operation.IN);
    }

    @Override
    public Predicate like(Variant<? extends U, ?> value) {
        checkSupport(Operation.LIKE);
        
        return Predicates.plainSigleStrParam(this, value, Operation.LIKE);
    }

    @Override
    public Predicate eq(Variant<? extends U, ?> value) {
        checkSupport(Operation.EQUAL);
        
        return Predicates.plainSigleStrParam(this, value, Operation.EQUAL);
    }

    @Override
    public Predicate notEq(Variant<? extends U, ?> value) {
        checkSupport(Operation.NOT_EQUAL);
        
        return Predicates.plainSigleStrParam(this, value, Operation.NOT_EQUAL);
    }

    @Override
    public Predicate gt(Variant<? extends U, ?> value) {
        checkSupport(Operation.GT);
        
        return Predicates.plainSigleStrParam(this, value, Operation.GT);
    }

    @Override
    public Predicate ge(Variant<? extends U, ?> value) {
        checkSupport(Operation.GE);
        
        return Predicates.plainSigleStrParam(this, value, Operation.GE);
    }

    @Override
    public Predicate lt(Variant<? extends U, ?> value) {
        checkSupport(Operation.LT);
        
        return Predicates.plainSigleStrParam(this, value, Operation.LT);
    }

    @Override
    public Predicate le(Variant<? extends U, ?> value) {
        checkSupport(Operation.LE);
        
        return Predicates.plainSigleStrParam(this, value, Operation.LE);
    }

    @Override
    public Predicate in(List<? extends Variant<? extends U, ?>> values) {
        checkSupport(Operation.IN);
        
        return Predicates.plainMultipleStrParams(this, values, Operation.IN);
    }

    @Override
    public Predicate isNull() {
        checkSupport(Operation.IS_NULL);
        
        return Predicates.noParam(this, Operation.IS_NULL);
    }

    @Override
    public Predicate notNull() {
        checkSupport(Operation.IS_NOT_NULL);
        
        return Predicates.noParam(this, Operation.IS_NOT_NULL);
    }
    
    @Override
    public String toString() {
        return getExp();
    }
}
