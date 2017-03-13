package com.jhqc.pxsj.core.query.function;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface ParameterizedVariant<T, U> extends Variant<T, U> {
    List<? extends Parameter<?>> getParams();
}
