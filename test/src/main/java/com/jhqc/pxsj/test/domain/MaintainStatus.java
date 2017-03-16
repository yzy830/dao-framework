package com.jhqc.pxsj.test.domain;

import com.jhqc.pxsj.core.type.DbEnum;

public enum MaintainStatus implements DbEnum {
    EXTENDED("1"),
    NON_EXTENDED("0");
    
    private String value;
    
    private MaintainStatus(String value) {
        this.value = value;
    }

    @Override
    public String getStringVal() {
        return value;
    }

}
