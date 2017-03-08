package com.jhqc.pxsj.annotation.process.util;

import com.jhqc.pxsj.annotation.process.exceptions.LoadFreemarkerTemplateException;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtil {
    private FreemarkerUtil() {
        throw new AssertionError();
    }
    
    private static final Configuration cfg;
    static {
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setClassForTemplateLoading(FreemarkerUtil.class, "/");
        cfg.setDefaultEncoding("UTF-8");
    }
    
    public static Template getTemplate(String name) {
        try {
            return cfg.getTemplate(name);
        } catch(Exception e) {
            throw new LoadFreemarkerTemplateException(name, e);
        }
    }
}
