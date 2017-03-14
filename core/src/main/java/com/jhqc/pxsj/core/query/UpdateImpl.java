package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.set.Setting;

class UpdateImpl<T> implements Update<T> {
    private String sql;
    
    private List<Parameter<?>> params = new ArrayList<>();
    
    public UpdateImpl(PostSetterImpl<T> setter) {
        StringBuilder builder = new StringBuilder().append("update ").append(setter.getRoot())
                                                   .append(" set ")
                                                   .append(setter.getSettings().stream().map(Setting::getExp).collect(Collectors.joining(", ")))
                                                   .append(" where ")
                                                   .append(setter.getPredicate().getExp());
        sql = builder.toString();
        
        for(Setting<?,?> setting : setter.getSettings()) {
            params.addAll(setting.getParams());
        }
        params.addAll(setter.getPredicate().getParams());
    }

    @Override
    public String create() {
        return sql;
    }

    @Override
    public List<? extends Parameter<?>> getParams() {
        return params;
    }

}
