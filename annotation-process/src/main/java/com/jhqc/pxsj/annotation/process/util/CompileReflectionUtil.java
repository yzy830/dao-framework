package com.jhqc.pxsj.annotation.process.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;

public class CompileReflectionUtil {
    private CompileReflectionUtil() {
        throw new AssertionError();
    }
    
    public static List<? extends Element> getMembersExceptObject(ProcessingEnvironment env, TypeElement elem) {
        List<Element> elems = new ArrayList<>();
        
        while(!isObject(elem)) {
            elems.addAll(elem.getEnclosedElements());
            
            elem = (TypeElement)env.getTypeUtils().asElement(elem.getSuperclass());
        }
        
        return elems;
    }
    
    private static boolean isObject(TypeElement elem) {
        return elem.getQualifiedName().toString().equals("java.lang.Object");
    }
    
    /**
     * 用于描述一个属性的静态信息
     *
     */
    public static class StaticPropertyDescriptor {
        private String name;
        
        private String typeName;
        
        public StaticPropertyDescriptor(String name, String typeName) {
            this.name = name;
            this.typeName = typeName;
        }

        /**
         * 属性名称
         * 
         * @return 属性名称
         */
        public String getName() {
            return name;
        }

        /**
         * 属性类型的全限定名称，例如java.lang.String
         * 
         * @return 属性类型的全限定名称
         */
        public String getTypeName() {
            return typeName;
        }
    }
    
    public static List<StaticPropertyDescriptor> getPropertyDescriptor(List<? extends Element> members) {
        List<StaticPropertyDescriptor> descriptors = new ArrayList<>();
        
        List<ExecutableElement> methods = ElementFilter.methodsIn(members);
        
        for(ExecutableElement method : methods) {
            String methodName = method.getSimpleName().toString();
            if(PropertyNameUtil.isProperty(methodName)) {
                String name = PropertyNameUtil.getPropertyName(methodName);
                String typeName = method.getReturnType().toString();
                
                descriptors.add(new StaticPropertyDescriptor(name, typeName));
            }
        }
        
        return descriptors;
    }

    public static List<String> getPropertyNames(List<? extends Element> members) {
        List<ExecutableElement> methods = ElementFilter.methodsIn(members);
        
        List<String> names = new ArrayList<>();
        for(ExecutableElement method : methods) {
            String methodName = method.getSimpleName().toString();
            if(PropertyNameUtil.isProperty(methodName)) {
                names.add(PropertyNameUtil.getPropertyName(methodName));
            }
        }
        
        return names;
    }
}
