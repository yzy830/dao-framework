package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.core.query.variants.SelectingVariant;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface Attribute<T, U> extends Variant<T, U>, SelectingVariant<T> {

}
