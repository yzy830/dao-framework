package com.jhqc.pxsj.annotation.process.meta;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import com.jhqc.pxsj.annotation.process.exceptions.SetterTypeMismatchException;
import com.jhqc.pxsj.annotation.process.util.NameUtil;

public class Id extends Meta {
    private PropertyDescriptor descriptor;

    public Id(PropertyDescriptor descriptor, com.jhqc.pxsj.domain.annotation.Id id) {
        super(descriptor);
        setColumnName(NameUtil.getIdColumnName(descriptor));
        this.descriptor = descriptor;
    }
    
    void setId(Object object, Object value) {
        if(!object.getClass().equals(descriptor.getWriteMethod().getDeclaringClass())) {
           throw new SetterTypeMismatchException(object, descriptor); 
        }
        
        try {
            descriptor.getWriteMethod().invoke(object, value);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
