package com.jhqc.pxsj.core;

import com.jhqc.pxsj.core.type.DbEnum;


public enum ShopStatus implements DbEnum {
    NORMAL("1"),
    DELETED("0");
    
    private String strValue;
    
    private ShopStatus(String strVal) {
        this.strValue = strVal;
    }

    @Override
    public String getStringVal() {
        return strValue;
    }
}
