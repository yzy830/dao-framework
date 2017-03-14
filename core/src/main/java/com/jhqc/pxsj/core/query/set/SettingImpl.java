package com.jhqc.pxsj.core.query.set;

import java.util.ArrayList;
import java.util.List;

import com.jhqc.pxsj.core.Parameterized;
import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.predicate.Parameters;
import com.jhqc.pxsj.core.query.variants.Variant;

public class SettingImpl<T, U> implements Setting<T, U> {
    private static final String SETTING_TEMPLATE = "%s = %s";
    
    private String exp;
    
    private List<Parameter<?>> params = new ArrayList<>();
    
    public SettingImpl(Attribute<T, U> attribute, T value) {
       exp = String.format(SETTING_TEMPLATE, attribute.getExp(), "?");
       params.add(Parameters.newInstance(attribute.getJavaType(), value));
    }
    
    public SettingImpl(Attribute<T, U> attribute, Variant<? extends U, ?> variant) {
        if(variant == null) {
            throw new IllegalArgumentException();
        }
        exp = String.format(SETTING_TEMPLATE, attribute.getExp(), variant.getExp());
        
        if(variant instanceof Parameterized) {
            Parameterized pVariant = (Parameterized)variant;
            params.addAll(pVariant.getParams());
        }
    }

    @Override
    public String getExp() {
        return exp;
    }

    @Override
    public List<? extends Parameter<?>> getParams() {
        return params;
    }

}
