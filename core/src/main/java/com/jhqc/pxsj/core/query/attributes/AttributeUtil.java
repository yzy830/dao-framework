package com.jhqc.pxsj.core.query.attributes;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.root.Root;

class AttributeUtil {
    static String genExp(Root<?> root, Meta<?,?> meta) {
        return new StringBuilder(root.getAlias()).append(".").append(meta.getColumnName()).toString();
    }
}
