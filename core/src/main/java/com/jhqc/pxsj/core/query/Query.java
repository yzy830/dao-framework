package com.jhqc.pxsj.core.query;

import java.util.List;

import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.core.query.variants.Variant;

public interface Query<T> extends Sql {
    public enum OrderType {
        ASC("asc"),
        DESC("desc")
        ;
        
        private String value;
        
        private OrderType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    Class<T> getResultType();
    
    List<? extends Parameter<?>> getParams();
    
    /**
     * 添加排序
     * 
     * @param variant
     *          排序变量
     * 
     * @return this
     */
    Query<T> orderBy(Variant<?, ?> variant, OrderType orderType);
    
    /**
     * 设置分页信息。第二次设置的值会覆盖第一次设置的值
     * 
     * @param offset
     *          开始位置
     * @param count
     *          行数
     *          
     * @return this
     */
    Query<T> setPage(int offset, int count); 
}
