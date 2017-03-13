package com.jhqc.pxsj.annotation.process.util;

import java.beans.PropertyDescriptor;

import com.jhqc.pxsj.domain.annotation.Id;
import com.jhqc.pxsj.domain.annotation.Join;
import com.jhqc.pxsj.domain.annotation.Property;


public class MetaUtil {
    private MetaUtil() {
        throw new AssertionError();
    }
    
    /**
     * 检测一个属性的元数据是否有效。在一个属性上，不可以同时存在@Id/@Property/@Join标签
     */
    public static boolean isMetaDupulicated(PropertyDescriptor property) {
        Id idAnnotation = property.getReadMethod().getAnnotation(Id.class);
        Property propertyAnnotation = property.getReadMethod().getAnnotation(Property.class);
        Join joinAnnotation = property.getReadMethod().getAnnotation(Join.class);
        
        int count = 0;
        if(idAnnotation != null) {
            ++count;
        }
        
        if(propertyAnnotation != null) {
            ++count;
        }
        
        if(joinAnnotation != null) {
            ++count;
        }
        
        return count > 1;
    }
}
