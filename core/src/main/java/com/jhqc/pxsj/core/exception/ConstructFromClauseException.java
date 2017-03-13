package com.jhqc.pxsj.core.exception;

import com.jhqc.pxsj.core.query.root.Root;

public class ConstructFromClauseException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 960970161110751573L;

    public ConstructFromClauseException(Root<?> root) {
        super(String.format("can only construct from clause on root[%s]", root.toString()));
    }
}
