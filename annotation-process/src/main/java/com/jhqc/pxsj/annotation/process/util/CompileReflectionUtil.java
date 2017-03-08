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
