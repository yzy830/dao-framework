package com.jhqc.pxsj.core.query.autoselect;

import com.jhqc.pxsj.core.meta.MetaPool;
import com.jhqc.pxsj.core.query.autoselect.meta.ResultMeta;
import com.jhqc.pxsj.core.query.autoselect.template.ClauseTemplate;
import com.jhqc.pxsj.core.query.root.Root;

public class SimpleSelector implements AutoSelector {    
    private ClauseTemplate template;
    
    public SimpleSelector(MetaPool pool, Class<?> result) {
        if(pool.getMeta(result) != null) {
            // 领域模型
            template = Util.constructSelectFromDomainMeta(pool.getMeta(result));
        } else {        
            template = Util.constructSelectFromResultMeta(new ResultMeta(result), pool);
        }
    }

    @Override
    public String select(Root<?> root) {
        return template.format(root);
    }

    public ClauseTemplate getTemplate() {
        return template;
    }
}
