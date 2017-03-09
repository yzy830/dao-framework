package com.jhqc.pxsj.core.query;

public abstract class AstractAttribute<T> implements Attribute<T> {
    protected Root<?> root;
    
    protected String columnName;
    
    private String path;
    
    public AstractAttribute(Root<?> root, String columnName) {
        this.root = root;
        this.columnName = columnName;
        this.path = new StringBuilder(root.getAlias()).append(".").append(columnName).toString();
    }
    
    @Override
    public String getPath() {
        return path;
    }
}
