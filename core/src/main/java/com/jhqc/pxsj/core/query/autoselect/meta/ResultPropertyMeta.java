package com.jhqc.pxsj.core.query.autoselect.meta;

public class ResultPropertyMeta {
    private String propertyName;
    
    private String alias;
    
    private String rootAlias;
    
    private String sourceProperty;
    
    private Class<?> source;
    
    public ResultPropertyMeta(String propertyName, String sourceProperty, Class<?> source, String rootAlias) {
        this.propertyName = propertyName;
        //直接使用属性名作为alias
        this.alias = propertyName;
        this.sourceProperty = sourceProperty;
        this.source = source;
        this.rootAlias = rootAlias;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getAlias() {
        return alias;
    }

    public String getSourceProperty() {
        return sourceProperty;
    }

    public Class<?> getSource() {
        return source;
    }

    public String getRootAlias() {
        return rootAlias;
    }
}
