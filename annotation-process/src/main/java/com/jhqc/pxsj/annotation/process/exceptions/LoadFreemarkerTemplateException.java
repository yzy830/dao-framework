package com.jhqc.pxsj.annotation.process.exceptions;

public class LoadFreemarkerTemplateException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -6928999463594156232L;

    public LoadFreemarkerTemplateException(String name, Exception e) {
        super("fail to load template[" + name + "]", e);
    }
}
