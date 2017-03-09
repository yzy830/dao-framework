package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.root.Root;
import com.jhqc.pxsj.core.query.root.RootUtil;

class FromImpl<T> implements From<T> {
    private SelectImpl<T> select;
    
    private Root<?> root;
    
    public FromImpl(SelectImpl<T> select) {
        this.select = select;
    }

    @Override
    public Where<T> from(Root<?> root) {
        this.root = root;
        
        return new WhereImpl<T>(this);
    }

    @Override
    public Class<T> getResultType() {
        return select.getResultType();
    }

    public Root<?> getRoot() {
        return root;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(select.toString()).append(" ");
        
        if(root != null) {
            builder.append(RootUtil.constructFromClause(root));
        }
        
        return builder.toString();
    }

    public SelectImpl<T> getSelect() {
        return select;
    }
}
