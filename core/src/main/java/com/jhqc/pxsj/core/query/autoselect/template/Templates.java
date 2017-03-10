package com.jhqc.pxsj.core.query.autoselect.template;

public class Templates {
    private Templates() {
        throw new AssertionError();
    }
    
    public static ClauseTemplate trival(String template) {
        return new TrivialTemplate(template);
    }
    
    public static ClauseTemplate rootOnly(String template, String placeHolder) {
        return new RootPlaceHolderTemplate(template, placeHolder);
    }
}
