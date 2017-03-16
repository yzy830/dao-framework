package com.jhqc.pxsj.dao.integration;

import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.jhqc.pxsj.core.type.DbEnum;
import com.jhqc.pxsj.dao.integration.exceptions.InvalidEnumValueException;

public class CustomBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T> {
    public CustomBeanPropertyRowMapper(Class<T> clazz) {
        super(clazz);
    }
    
    public static <T> CustomBeanPropertyRowMapper<T> newInstance(Class<T> clazz) {
        return new CustomBeanPropertyRowMapper<>(clazz);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Object getColumnValue(ResultSet rs, int index, PropertyDescriptor pd) throws SQLException {
        if(Enum.class.isAssignableFrom(pd.getPropertyType())) {
            if(DbEnum.class.isAssignableFrom(pd.getPropertyType())) {
                Object[] enums = pd.getPropertyType().getEnumConstants();
                String r = rs.getString(index);
                for(Object e : enums) {
                    DbEnum dbEnum = (DbEnum)e;
                    if(dbEnum.getStringVal().equals(r)) {
                        return e;
                    }
                }
                
                throw new InvalidEnumValueException(r, pd);
            } else {
                return Enum.valueOf((Class<Enum>)pd.getPropertyType(), rs.getString(index));
            }
        }
        
        return super.getColumnValue(rs, index, pd);
    }
}
