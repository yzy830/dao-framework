package ${package};

import com.jhqc.pxsj.annotation.process.meta.Meta;
import com.jhqc.pxsj.annotation.process.util.ReflectionUtil;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class ${className} {
    private static final Class<?> domain = ${domainFullQualifiedName}.class;

    private static final Map<String, PropertyDescriptor> descriptors = ReflectionUtil.getPropertyDescriptorMap(domain); 
    <#list infos as info>
    
    public static final Meta<${info.typeName}, ${info.matchTypeName}> ${info.name} = Meta.<${info.typeName}, ${info.matchTypeName}>newInstance(descriptors.get("${info.name}"));
    </#list>
}