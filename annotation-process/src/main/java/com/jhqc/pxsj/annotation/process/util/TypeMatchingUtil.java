package com.jhqc.pxsj.annotation.process.util;

import java.io.IOException;
import java.util.Properties;

public final class TypeMatchingUtil {
    private TypeMatchingUtil() {
        throw new AssertionError();
    }
    
    private static final Properties properties;
    
    static {
        properties = new Properties();
        try {
            properties.load(TypeMatchingUtil.class.getResourceAsStream("/type-match.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getTypeMatch(String fullQualifiedName) {
        return properties.getProperty(fullQualifiedName, fullQualifiedName);
    }
}
