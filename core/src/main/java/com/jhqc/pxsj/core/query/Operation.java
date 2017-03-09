package com.jhqc.pxsj.core.query;

public enum Operation {
    LIKE {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" like ").append("?").toString();
        }

        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            return new StringBuilder().append(path).append(" like ").append(vars[0]).toString(); 
        }
        
    },
    
    EQUAL {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" = ").append("?").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            return new StringBuilder().append(path).append(" = ").append(vars[0]).toString();
        }
    },
    
    NOT_EQUAL {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" <> ").append("?").toString(); 
        }
        
        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            return new StringBuilder().append(path).append(" <> ").append(vars[0]).toString(); 
        }
    },
    
    GT {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" > ").append("?").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            return new StringBuilder().append(path).append(" > ").append(vars[0]).toString();
        }
    },
    GE {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" >= ").append("?").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            return new StringBuilder().append(path).append(" >= ").append(vars[0]).toString();
        }
    },
    LT {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" < ").append("?").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            return new StringBuilder().append(path).append(" < ").append(vars[0]).toString();
        }
    },
    LE {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" <= ").append("?").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 1;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            return new StringBuilder().append(path).append(" <= ").append(vars[0]).toString();
        }
    },
    IN {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            StringBuilder builder = new StringBuilder().append(path).append(" in (").append("?");
            
            for(int i = 1; i < paramCount; ++i) {
                builder.append(",?");
            }        
            builder.append(")");
            
            return builder.toString();
        }
        
        @Override
        public int maxParamCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int minParamCount() {
            return 1;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            checkParamCount(vars.length);
            
            StringBuilder builder = new StringBuilder().append(path).append(" in (").append(vars[0]);
            
            for(int i = 1; i < vars.length; ++i) {
                builder.append(",").append(vars[i]);
            }        
            builder.append(")");
            
            return builder.toString();
        }
        
    },
    
    IS_NULL {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" is null").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 0;
        }

        @Override
        public int minParamCount() {
            return 0;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            return formatPrepared(path, vars.length);
        }
        
    },
    
    IS_NOT_NULL {

        @Override
        public String formatPrepared(String path, int paramCount) {
            checkParamCount(paramCount);
            
            return new StringBuilder().append(path).append(" is not null").toString();
        }
        
        @Override
        public int maxParamCount() {
            return 0;
        }

        @Override
        public int minParamCount() {
            return 0;
        }

        @Override
        public String formatPlain(String path, String... vars) {
            return formatPrepared(path, vars.length);
        }
        
    }
    ;
    
    protected void checkParamCount(int paramCount) {
        if((paramCount < minParamCount()) || (paramCount > maxParamCount())) {
            throw new IllegalArgumentException();
        }
    }
    
    public abstract int minParamCount();
    
    public abstract int maxParamCount();
    
    /**
     * 生成PreparedStatement格式条件语句，例如 name like ?
     * 
     * @param path
     *          查询目标变量
     * @param paramCount
     *          变量个数
     * @return 格式化条件语句
     */
    public abstract String formatPrepared(String path, int paramCount);
    
    /**
     * 生成Statement格式条件语句，例如 time < now()，name like '123'
     * 
     * @param path
     *          查询目标变量
     * @param vars
     *          文本变量
     *          
     * @return 条件语句
     */
    public abstract String formatPlain(String path, String...vars);
}
