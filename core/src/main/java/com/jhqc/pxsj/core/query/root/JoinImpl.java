package com.jhqc.pxsj.core.query.root;

import com.jhqc.pxsj.annotation.process.dynamicmeta.DomainMeta;
import com.jhqc.pxsj.annotation.process.dynamicmeta.JoinRelation;
import com.jhqc.pxsj.annotation.process.util.PropertyNameUtil;
import com.jhqc.pxsj.core.exception.LackJoinException;
import com.jhqc.pxsj.core.meta.MetaPool;

class JoinImpl<T, U> extends RootImpl<U> implements Join<T, U> {
    private static final String AUTO_ALIAS_PREFIX = "_j_";
    
    public enum JoinType {
        LEFT("left join"),
        INNER("join")
        ;
        
        private String join;
        
        private JoinType(String join) {
            this.join = join;
        }

        public String getJoin() {
            return join;
        }
    }
    
    private JoinType joinType;
    
    private Root<T> root;
    
    private String rootColumn;
    
    private String joinColumn;
    
    public JoinImpl(Class<?> domain, MetaPool pool, JoinType joinType, Root<T> root) {
        this(domain, pool, generateAlias(domain, pool, ((RootImpl<T>)root).getGenerator()), joinType, root);
    }

    public JoinImpl(Class<?> domain, MetaPool pool, String alias, JoinType joinType, Root<T> root) {
        super(domain, pool, alias);
        DomainMeta rootMeta = ((RootImpl<T>)root).domainMeta;   
        if(rootMeta.getJoinRelations().containsKey(domain)) {
            //root包含连接信息
            JoinRelation r = rootMeta.getJoinRelations().get(domain);
            this.rootColumn = r.getSourceColumnName();
            this.joinColumn = r.getTargetColumnName();
        } else if(domainMeta.getJoinRelations().containsKey(rootMeta.getDomainModel())) {
            //join目标包含连接信息
            JoinRelation r = domainMeta.getJoinRelations().get(rootMeta.getDomainModel());
            this.rootColumn = r.getTargetColumnName();
            this.joinColumn = r.getSourceColumnName();
        } else {
            //两者都不包含
            throw new LackJoinException(rootMeta.getDomainModel(), domainMeta.getDomainModel());
        }
        
        this.joinType = joinType;
        this.root = root;
    }

    private static String generateAlias(Class<?> domain, MetaPool pool, AliasGenerator generator) {
        DomainMeta domainMeta = pool.getMeta(domain);
        if(domainMeta == null) {
            throw new IllegalArgumentException(String.format("class[%s] is not a domain model", domain.getName()));
        }
        
        return generator.generate(AUTO_ALIAS_PREFIX + PropertyNameUtil.underscoreName(domainMeta.getEntityName()));
    }
    
    @Override
    public String getAliasedExp() {
        return new StringBuilder().append(joinType.getJoin()).append(" ")
                .append(domainMeta.getTable()).append(" ")
                .append(getAlias()).append(" on ")
                .append(root.getAlias()).append(".").append(rootColumn)
                .append(" = ")
                .append(this.getAlias()).append(".").append(joinColumn)
                .toString();
    }
    
    @Override
    public String toString() {
        return getAliasedExp();
    }
    
    protected AliasGenerator getGenerator() {
        return ((RootImpl<T>)root).getGenerator();
    }
    
    @Override
    public String getJoinChainExpression() {
        throw new UnsupportedOperationException(String.format("can only get join chain on a root, but this is a join[%s]", this));
    }
}
