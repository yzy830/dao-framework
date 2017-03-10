package com.jhqc.pxsj.core.query.autoselect.template;

import com.jhqc.pxsj.core.query.root.Root;

public class TrivialTemplate implements ClauseTemplate {
    private String template;
    
    public TrivialTemplate(String template) {
        this.template = template;
    }

    @Override
    public String format(Root<?> root) {
        return template;
    }

    @Override
    public String getTemplate() {
        return template;
    }

}
