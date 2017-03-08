package com.jhqc.pxsj.annotation.process.dynamicmeta;

import java.beans.PropertyDescriptor;

import org.apache.commons.lang3.StringUtils;

import com.jhqc.pxsj.annotation.process.exceptions.JoinAbsentPropertyException;
import com.jhqc.pxsj.annotation.process.util.NameUtil;
import com.jhqc.pxsj.domain.annotation.Join;

/**
 * 描述连接关系
 *
 */
public class JoinRelation {
    private DomainMeta domainModel;
    
    private Class<?> target;
    
    private String sourceColumnName;
    
    private String targetColumnName;
    
    public JoinRelation(DomainMeta domainModel, PropertyDescriptor descriptor, Join join) {        
        this.domainModel = domainModel;
        this.target = join.domain();
        this.sourceColumnName = NameUtil.getJoinColumnName(descriptor);
        this.targetColumnName = NameUtil.getTargetJoinColumName(join);
        
        if(StringUtils.isEmpty(this.targetColumnName)) {
            throw new JoinAbsentPropertyException(target, join.refProperty());
        }
    }

    public DomainMeta getDomainModel() {
        return domainModel;
    }

    public Class<?> getTarget() {
        return target;
    }

    public String getSourceColumnName() {
        return sourceColumnName;
    }

    public String getTargetColumnName() {
        return targetColumnName;
    } 
}
