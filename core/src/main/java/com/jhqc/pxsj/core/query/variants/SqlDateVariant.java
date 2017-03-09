package com.jhqc.pxsj.core.query.variants;

import java.util.Date;

/**
 * java.sql.Date对应的变量
 *
 */
public class SqlDateVariant extends DateAbstractVariant<java.sql.Date, Date> {

    public SqlDateVariant(Class<java.sql.Date> javaType, String exp) {
        super(javaType, exp);
    }
}
