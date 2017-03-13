package com.jhqc.pxsj.core;

/**
 * 表示必须使用别名的字符串表达式，例如一个root/join，必须具有别名(root可以不使用别名，为了处理简单，我们认为root也需要具有别名，如果用户没有提供，会自动生成一个别名)
 *
 */
public interface AliasedExpression extends Aliased {
    /**
     * 具有别名的表达式
     * 
     * @return 具有别名的表达式
     */
    String getAliasedExp();
}
