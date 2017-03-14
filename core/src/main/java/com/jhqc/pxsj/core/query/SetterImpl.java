package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.set.Setting;
import com.jhqc.pxsj.core.query.set.Settings;
import com.jhqc.pxsj.core.query.variants.Variant;

class SetterImpl<T> implements Setter<T> {
    private List<Setting<?, ?>> settings = new ArrayList<>();
    
    private Predicate predicate;
    
    private DomainMeta domainMeta;
    
    public SetterImpl(DomainMeta domainMeta) {
        if(domainMeta == null) {
            throw new IllegalArgumentException();
        }
        
        this.domainMeta = domainMeta;
    }

    @Override
    public <X, Y> Setter<T> set(Attribute<X, Y> attribute, X value) {
        settings.add(Settings.setValue(attribute, value));
        return new PostSetterImpl<>(this);
    }

    @Override
    public <X, Y> Setter<T> set(Attribute<X, Y> attribute,
            Variant<? extends Y, ?> value) {
        settings.add(Settings.setVariant(attribute, value));
        return new PostSetterImpl<>(this);
    }
    
    public List<? extends Setting<?, ?>> getSettings() {
        return Collections.unmodifiableList(settings);
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public DomainMeta getDomainMeta() {
        return domainMeta;
    }
}
