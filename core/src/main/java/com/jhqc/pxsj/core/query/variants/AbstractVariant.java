package com.jhqc.pxsj.core.query.variants;

import java.util.Arrays;
import java.util.List;

import com.jhqc.pxsj.core.query.Operation;
import com.jhqc.pxsj.core.query.Variant;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.predicate.Predicates;

public abstract class AbstractVariant<T, U> implements Variant<T, U> {
    
    private Class<T> javaType;
    
    private String exp;
    
    public AbstractVariant(Class<T> javaType, String exp) {
        this.javaType = javaType;
        this.exp = exp;
    }

    /**
     * 变量的表达式，例如now，sum(t_d_order_base.amount)等
     * 
     * @return 表达式 
     */
    public String getExp() {
        return exp;
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
    public Predicate like(U value) {
        checkSupport(Operation.LIKE);
        
        return Predicates.singleParam(this, value, Operation.LIKE);
    }

    @Override
    public Predicate equal(U value) {
        checkSupport(Operation.EQUAL);
        
        return Predicates.singleParam(this, value, Operation.EQUAL);
    }

    @Override
    public Predicate notEqual(U value) {
        checkSupport(Operation.NOT_EQUAL);
        
        return Predicates.singleParam(this, value, Operation.NOT_EQUAL);
    }

    @Override
    public Predicate gt(U value) {
        checkSupport(Operation.GT);
        
        return Predicates.singleParam(this, value, Operation.GT);
    }

    @Override
    public Predicate ge(U value) {
        checkSupport(Operation.GE);
        
        return Predicates.singleParam(this, value, Operation.GE);
    }

    @Override
    public Predicate lt(U value) {
        checkSupport(Operation.LT);
        
        return Predicates.singleParam(this, value, Operation.LT);
    }

    @Override
    public Predicate le(U value) {
        checkSupport(Operation.LE);
        
        return Predicates.singleParam(this, value, Operation.LE);
    }

    @Override
    public Predicate in(U[] values) {
        checkSupport(Operation.IN);
        
        return Predicates.multipleParam(this, Arrays.asList(values), Operation.IN);
    }

    @Override
    public Predicate like(Variant<U, ?> value) {
        checkSupport(Operation.LIKE);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.LIKE);
    }

    @Override
    public Predicate equal(Variant<U, ?> value) {
        checkSupport(Operation.EQUAL);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.EQUAL);
    }

    @Override
    public Predicate notEqual(Variant<U, ?> value) {
        checkSupport(Operation.NOT_EQUAL);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.NOT_EQUAL);
    }

    @Override
    public Predicate gt(Variant<U, ?> value) {
        checkSupport(Operation.GT);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.GT);
    }

    @Override
    public Predicate ge(Variant<U, ?> value) {
        checkSupport(Operation.GE);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.GE);
    }

    @Override
    public Predicate lt(Variant<U, ?> value) {
        checkSupport(Operation.LT);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.LT);
    }

    @Override
    public Predicate le(Variant<U, ?> value) {
        checkSupport(Operation.LE);
        
        return Predicates.plainSigleStrParam(this, (AbstractVariant<U, ?>)value, Operation.LE);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Predicate in(List<? extends Variant<U, ?>> values) {
        checkSupport(Operation.IN);
        
        return Predicates.plainMultipleStrParams(this, (List<AbstractVariant<U, ?>>)values, Operation.IN);
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
}
