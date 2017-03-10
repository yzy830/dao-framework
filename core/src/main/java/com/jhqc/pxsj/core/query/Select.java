package com.jhqc.pxsj.core.query;

import com.jhqc.pxsj.core.query.variants.SelectingVariant;

public interface Select<T> {
    From<T> select(SelectingVariant<?>...variant);
    
    /**
     * 只允许对领域模型或者使用{@link Source}标注的结果集使用autoSelect
     * 
     * @return From对象
     * 
     * @throws InvalidResultClassException 结果集没有使用{@link Source}标注
     * @throws MismatchPropertyException 结果集合数据源的属性不匹配
     * @throws SourceException 结果集的数据源不是领域模型
     */
    From<T> autoSelect();
    
    Class<T> getResultType();
}
