package com.jhqc.pxsj.annotation.process.exceptions;

public class GetBeanInfoExceptoin extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8493364348995125150L;

    private Class<?> clazz;
    
    public GetBeanInfoExceptoin(Class<?> clazz, Exception e) {
        super("fail to get bean descriptors when generate dao meta model, class = " + clazz, e);
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
