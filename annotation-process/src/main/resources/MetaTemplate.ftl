package ${package};

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class ${className} {
    public static final Class<?> domain = ${domainFullQualifiedName}.class;

    private static final Map<String, PropertyDescriptor> descriptors = ReflectionUtil.getPropertyDescriptorMap(domain); 
    <#list names as name>
    
    public static final Meta ${name} = Meta.newInstance(descriptors.get("${name}"));
    </#list>
}