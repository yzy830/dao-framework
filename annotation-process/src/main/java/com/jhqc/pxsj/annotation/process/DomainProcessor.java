package com.jhqc.pxsj.annotation.process;

import java.io.BufferedWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.jhqc.pxsj.annotation.process.util.CompileReflectionUtil.StaticPropertyDescriptor;
import com.jhqc.pxsj.annotation.process.util.FreemarkerUtil;
import com.jhqc.pxsj.annotation.process.util.TypeMatchingUtil;
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
                
                List<MetaInfo> infos = new ArrayList<>();
                for(StaticPropertyDescriptor descriptor : CompileReflectionUtil.getPropertyDescriptor(CompileReflectionUtil.getMembersExceptObject(processingEnv, clazzElem))) {
                    infos.add(new MetaInfo(descriptor));
                }   
                root.put("infos", infos);
                
                processingEnv.getTypeUtils().asElement(clazzElem.getSuperclass());
                JavaFileObject javaFile = processingEnv.getFiler().createSourceFile(fullQualifiedName);
                try(Writer writer = javaFile.openWriter();
                    BufferedWriter bw = new BufferedWriter(writer)) {                    
                    metaTemplate.process(root, bw);                    
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
    
    public static class MetaInfo {
        private String name;
        
        private String typeName;
        
        private String matchTypeName;
        
        public MetaInfo(StaticPropertyDescriptor descriptor) {
            this.name = descriptor.getName();
            this.typeName = descriptor.getTypeName();
            this.matchTypeName = TypeMatchingUtil.getTypeMatch(this.typeName);
        }

        public String getName() {
            return name;
        }

        public String getTypeName() {
            return typeName;
        }

        public String getMatchTypeName() {
            return matchTypeName;
        }
    }
}
