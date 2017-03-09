package com.jhqc.pxsj.annotation.process;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import com.jhqc.pxsj.annotation.process.util.CompileReflectionUtil;
import com.jhqc.pxsj.annotation.process.util.FreemarkerUtil;
import com.jhqc.pxsj.domain.annotation.Domain;

import freemarker.template.Template;

@SupportedAnnotationTypes("com.jhqc.pxsj.domain.annotation.Domain")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DomainProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        try {
            Template metaTemplate = FreemarkerUtil.getTemplate("MetaTemplate.ftl");
            
            for(Element elem : roundEnv.getElementsAnnotatedWith(Domain.class)) {
                TypeElement clazzElem = (TypeElement)elem;
                
                String simpleClassName = clazzElem.getSimpleName() + "_";
                String fullQualifiedName = clazzElem.getQualifiedName() + "_";
                PackageElement packageElement = processingEnv.getElementUtils().getPackageOf(clazzElem);
                
                Map<String, Object> root = new HashMap<>();
                root.put("package", packageElement.getQualifiedName());
                root.put("className", simpleClassName);
                root.put("domainFullQualifiedName", clazzElem.getQualifiedName());
                root.put("descriptors", CompileReflectionUtil.getPropertyDescriptor(CompileReflectionUtil.getMembersExceptObject(processingEnv, clazzElem)));
                
                processingEnv.getTypeUtils().asElement(clazzElem.getSuperclass());
            
                try {
                    JavaFileObject javaFile = processingEnv.getFiler().createSourceFile(fullQualifiedName);
                    BufferedWriter bw = new BufferedWriter(javaFile.openWriter());
                    metaTemplate.process(root, bw);
                    bw.close();
                    
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "生成" + fullQualifiedName);
                } catch(Exception e) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage(), elem);
                }
            }          
        } catch(Exception e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage());
        } 
        
        return true;
    }
}
