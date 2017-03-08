package com.jhqc.pxsj.annotation.process.dynamicmeta;

import java.beans.PropertyDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.annotation.process.exceptions.DuplicatedIdConfigException;
import com.jhqc.pxsj.annotation.process.exceptions.DuplicatedMetaConfigException;
import com.jhqc.pxsj.annotation.process.util.MetaUtil;
import com.jhqc.pxsj.annotation.process.util.NameUtil;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;
import com.jhqc.pxsj.domain.annotation.Domain;
import com.jhqc.pxsj.domain.annotation.Id;
import com.jhqc.pxsj.domain.annotation.Join;
import com.jhqc.pxsj.domain.annotation.Property;

public class DomainMeta {
    private Class<?> domainModel;
    
    private String table;
    
    private String entityName;
    
    private IdMeta idMeta;

    /**
     * 从属性名到属性元数据的映射
     */
    private Map<String, PropertyMeta> propertyMetas = new HashMap<>();
    
    /**
     * 从类到连接关系元数据的映射
     */
    private Map<Class<?>, JoinRelation> joinRelations = new HashMap<>();
    
    public DomainMeta(Class<?> domainModel) {
        Domain domainAnnotation = domainModel.getAnnotation(Domain.class);
        
        if(domainAnnotation == null) {
            throw new IllegalArgumentException("class[" + domainModel.getName() + "] is not a domain model");
        }
        
        this.domainModel = domainModel;
        this.table = domainAnnotation.table();
        if(StringUtils.isEmpty(table)) {
            throw new IllegalArgumentException("table name of domain model cannot be empty, class[" + domainModel.getName() + "]");
        }
        this.entityName = NameUtil.getEntityName(domainModel, domainAnnotation);
        
        PropertyDescriptor[] properties = ReflectionUtil.getPropertyDescriptors(domainModel);
        for(PropertyDescriptor property : properties) {
            if(!MetaUtil.isMetaDupulicated(property)) {
                throw new DuplicatedMetaConfigException(domainModel, property);
            }
            
            Id idAnnotation = property.getReadMethod().getAnnotation(Id.class);            
            
            if(idAnnotation != null) {
                if(this.idMeta != null) {
                    throw new DuplicatedIdConfigException(domainModel, idMeta.getDescriptor(), property);
                }
                
                this.idMeta = new IdMeta(this, property, idAnnotation);
            } else {
                Join joinAnnotation = property.getReadMethod().getAnnotation(Join.class);
                if(joinAnnotation != null) {
                    propertyMetas.put(property.getName(), new PropertyMeta(this, property, joinAnnotation));
                    joinRelations.put(joinAnnotation.domain(), new JoinRelation(this, property, joinAnnotation));
                } else {
                    Property propertyAnnotation = property.getReadMethod().getAnnotation(Property.class);
                    propertyMetas.put(property.getName(), new PropertyMeta(this, property, propertyAnnotation));
                }
            }
        }
    }

    public Class<?> getDomainModel() {
        return domainModel;
    }

    public String getTable() {
        return table;
    }

    public String getEntityName() {
        return entityName;
    }

    public IdMeta getIdMeta() {
        return idMeta;
    }

    public Map<String, PropertyMeta> getPropertyMetas() {
        return Collections.unmodifiableMap(propertyMetas);
    }

    public Map<Class<?>, JoinRelation> getJoinRelations() {
        return Collections.unmodifiableMap(joinRelations);
    }
}
