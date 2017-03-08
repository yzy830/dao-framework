package com.jhqc.pxsj.annotation.process;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import com.jhqc.pxsj.annotation.process.DomainProcessor;

public class App {
    public static void main( String[] args ) throws IOException {
        
        
        Iterable<JavaFileObject> files = getSourceFiles("src/main/java");
        
        for(JavaFileObject object : files) {
            System.out.println(object.getName());
        }
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        CompilationTask task = compiler.getTask(new PrintWriter(System.out), null, null, null, null, files);
        
        task.setProcessors(Arrays.asList(new DomainProcessor()));
        
        task.call();
    }
    
    private static Iterable<JavaFileObject> getSourceFiles(String path) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        StandardJavaFileManager files = compiler.getStandardFileManager(null, null, null);
        
        files.setLocation(StandardLocation.SOURCE_PATH, Arrays.asList(new File(path)));
        
        return files.list(StandardLocation.SOURCE_PATH, "", Collections.singleton(Kind.SOURCE), true);
    }
}
