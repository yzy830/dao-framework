package com.jhqc.pxsj.annotation.process.util;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class PropertyNameUtil {
    /**
     * 将驼峰规则属性名转换为下划线，例如goodsName -> goods_name
     * 
     * @param name
     * @return
     */
    public static String underscoreName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        result.append(lowerCaseName(name.substring(0, 1)));
        for (int i = 1; i < name.length(); i++) {
            String s = name.substring(i, i + 1);
            String slc = lowerCaseName(s);
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            }
            else {
                result.append(s);
            }
        }
        return result.toString();
    }

    public static String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }
    
    public static boolean isProperty(String methodName) {
        return methodName.startsWith("get") || methodName.startsWith("is");
    }
    
    public static String getPropertyName(String getterName) {
        StringBuilder builder = new StringBuilder();
        
        if(getterName.startsWith("is")) {
            return builder.append(getterName.substring(2, 3).toLowerCase(Locale.US)).append(getterName.substring(3)).toString();
        } else if(getterName.startsWith("get")) {
            return builder.append(getterName.substring(3, 4).toLowerCase(Locale.US)).append(getterName.substring(4)).toString();
        } else {
            throw new IllegalArgumentException("[" + getterName + "] is not a getter");
        }
    }
}
