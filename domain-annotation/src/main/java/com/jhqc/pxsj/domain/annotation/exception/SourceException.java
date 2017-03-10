package com.jhqc.pxsj.domain.annotation.exception;

/**
 * 数据源不是一个领域模型
 *
 */
public class SourceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -1174690843145899833L;
    
    public SourceException(Class<?> resultType, Class<?> source) {
        super(String.format("source[%s] of result type[%s] is not a domain model", source, resultType));
    }
}
