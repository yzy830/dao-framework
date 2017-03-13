package com.jhqc.pxsj.core.query.predicate;

public final class Parameters {
    private Parameters() {
        throw new AssertionError();
    }
    
    public static <T> Parameter<T> newInstance(Class<T> javaType, T value) {
        return new ParameterImpl<>(javaType, value);
    }
}
