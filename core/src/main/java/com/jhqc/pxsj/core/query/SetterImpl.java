package com.jhqc.pxsj.core.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.set.Setting;
import com.jhqc.pxsj.core.query.set.Settings;
import com.jhqc.pxsj.core.query.variants.Variant;

class SetterImpl<T> implements Setter<T> {
    private List<Setting<?, ?>> settings = new ArrayList<>();
    
    private Root<T> root;
    
    public SetterImpl(Root<T> root) {
        this.root = root;
    }
    
    protected SetterImpl(Root<T> root, List<? extends Setting<?, ?>> settings) {
        this.root = root;
        this.settings.addAll(settings);
    }

    @Override
    public <X, Y> PostSetter<T> set(Attribute<X, Y> attribute, X value) {
        settings.add(Settings.setValue(attribute, value));
        return new PostSetterImpl<>(this);
    }

    @Override
    public <X, Y> PostSetter<T> set(Attribute<X, Y> attribute,
            Variant<? extends Y, ?> value) {
        settings.add(Settings.setVariant(attribute, value));
        return new PostSetterImpl<>(this);
    }
    
    public List<? extends Setting<?, ?>> getSettings() {
        return Collections.unmodifiableList(settings);
    }

    public Root<T> getRoot() {
        return root;
    }
}
