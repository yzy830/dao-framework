package com.jhqc.pxsj.core.query.autoselect;

import com.jhqc.pxsj.core.query.autoselect.template.ClauseTemplate;
import com.jhqc.pxsj.core.query.root.Root;

public interface AutoSelector {
    String select(Root<?> root);
    
    ClauseTemplate getTemplate();
}
