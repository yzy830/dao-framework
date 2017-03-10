package com.jhqc.pxsj.core.query.autoselect.template;

import com.jhqc.pxsj.core.query.root.Root;

public interface ClauseTemplate {
    String format(Root<?> root);
    
    String getTemplate();
}
