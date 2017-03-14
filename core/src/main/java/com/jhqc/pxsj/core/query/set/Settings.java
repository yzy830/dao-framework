package com.jhqc.pxsj.core.query.set;

import com.jhqc.pxsj.core.query.attributes.Attribute;
import com.jhqc.pxsj.core.query.variants.Variant;

public final class Settings {
    private Settings() {
        throw new AssertionError();
    }
    
    public static <T, U> Setting<T, U> setValue(Attribute<T, U> attribute, T value) {
        return new SettingImpl<>(attribute, value);
    }
    
    public static <T, U> Setting<T, U> setVariant(Attribute<T, U> attribute, Variant<? extends U, ?> variant) {
        return new SettingImpl<>(attribute, variant);
    }
}
