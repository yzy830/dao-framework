package com.jhqc.pxsj.core.query.autoselect.template;

import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.root.RootUtil;

/**
 * @author Administrator
 *
 */
class RootPlaceHolderTemplate implements ClauseTemplate {
    private String template;
    
    private String placeHolder;
    
    public RootPlaceHolderTemplate(String template, String placeHolder) {
        this.template = template;
        this.placeHolder = placeHolder;
    }

    @Override
    public String format(Root<?> root) {
        if(root == null) {
            throw new IllegalArgumentException();
        }
        
        if(RootUtil.isJoin(root.getClass())) {
            throw new UnsupportedOperationException("the input parameter is a join");
        }
        
        return template.replaceAll(placeHolder, root.getAlias());
    }

    @Override
    public String getTemplate() {
        return template;
    }

}
