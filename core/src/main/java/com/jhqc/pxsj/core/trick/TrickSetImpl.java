package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.query.variants.Variant;

class TrickSetImpl<D> implements TrickSet<D> {
    private TrickUpdateImpl<D> trickUpdate;
    
    public TrickSetImpl(TrickUpdateImpl<D> trickUpdate) {
        this.trickUpdate = trickUpdate;
    }

    @Override
    public <X, Y> PostTrickSet<D> set(Meta<X, Y> property, X value) {
        trickUpdate.set(property, value);
        return new PostTrickSetImpl<>(trickUpdate);
    }

    @Override
    public <X, Y> PostTrickSet<D> set(Meta<X, Y> property,
            Variant<? extends Y, ?> value) {
        trickUpdate.set(property, value);
        return new PostTrickSetImpl<>(trickUpdate);
    }

    @Override
    public <X, Y> PostTrickSet<D> set(Meta<X, Y> property,
            VariantGenerator<X, Y> g) {
        trickUpdate.set(property, g.generate(trickUpdate.getRoot(), property));
        return new PostTrickSetImpl<>(trickUpdate);
    }

}
