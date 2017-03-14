package com.jhqc.pxsj.core.trick;

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.core.CriteriaBuilder;
import com.jhqc.pxsj.core.query.PostSetter;
import com.jhqc.pxsj.core.query.Setter;
import com.jhqc.pxsj.core.query.Update;
import com.jhqc.pxsj.core.query.predicate.Predicate;
import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.variants.Variant;

class TrickUpdateImpl<D> implements TrickUpdate<D> {
    private CriteriaBuilder builder;
    
    private TrickType type;
    
    private Class<D> domain;
    
    private Root<D> root;
    
    private Setter<D> setter;
    
    private PostSetter<D> postSetter;
    
    private Predicate predicate;
    
    public TrickUpdateImpl(CriteriaBuilder builder, TrickType type, Class<D> domain) {
        if((builder == null) || (type == null) || (domain == null)) {
            throw new IllegalArgumentException();
        }
        
        this.builder = builder;
        this.type = type;
        this.domain = domain;
        
        if(type == TrickType.AND) {
            this.predicate = builder.alwaysTrue();
        } else /* (type == TrickType.OR) */ {
            this.predicate = builder.alwaysFalse();
        }
        
        setter = builder.createUpdate(domain);
    }

    @Override
    public TrickUpdateRoot<D> root() {
        root = builder.root(domain);
        return new TrickUpdateRootImpl<>(this, root);
    }

    @Override
    public Class<D> getDomain() {
        return domain;
    }
    
    public void composite(Predicate p) {
        if(type == TrickType.AND) {
            predicate = predicate.and(p);
        } else /* (type == TrickType.OR) */ {
            predicate = predicate.or(p);
        }
    }
    
    public <X, Y> void set(Meta<X, Y> property, X value) {
        if(postSetter != null) {
            postSetter.set(root.get(property), value);
        } else {
            postSetter = setter.set(root.get(property), value);
        }
    }
    
    public <X, Y> void set(Meta<X, Y> property, Variant<? extends Y, ?> value) {
        if(postSetter != null) {
            postSetter.set(root.get(property), value);
        } else {
            postSetter = setter.set(root.get(property), value);
        }
    }

    public Update<D> done() {
        return postSetter.where(predicate);
    }
}
