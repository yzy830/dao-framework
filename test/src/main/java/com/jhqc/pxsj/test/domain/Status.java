package com.jhqc.pxsj.test.domain;

import com.jhqc.pxsj.core.type.DbEnum;

public enum Status implements DbEnum {
    VALID("1"),
    INVLIAD("0");
    
    private String value;
    
    private Status(String value) {
        this.value = value;
    }

    @Override
    public String getStringVal() {
        return value;
    }

}
