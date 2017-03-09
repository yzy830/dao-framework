package com.jhqc.pxsj.core.query.variants;

import java.util.Date;

/**
 * 表示java.util.Date对应的变量类型
 *
 */
public class DateVariant extends DateAbstractVariant<Date, Date> {

    public DateVariant(Class<Date> javaType, String exp) {
        super(javaType, exp);
    }
}
