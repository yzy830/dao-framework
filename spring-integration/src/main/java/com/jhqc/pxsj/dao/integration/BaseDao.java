package com.jhqc.pxsj.dao.integration;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jhqc.pxsj.core.CriteriaBuilder;
import com.jhqc.pxsj.core.query.Insert;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.Update;
import com.jhqc.pxsj.core.query.predicate.Parameter;
import com.jhqc.pxsj.dao.integration.exceptions.IdTypeMismatchException;
import com.jhqc.pxsj.dao.integration.exceptions.InsertException;

public abstract class BaseDao {
    protected JdbcTemplate jtm;
    
    protected CriteriaBuilder builder;
    
    protected BaseDao(JdbcTemplate jtm, CriteriaBuilder builder) {
        this.jtm = jtm;
        this.builder = builder;
    }
    
    private Number resolveId(Number id, Class<?> idType) {
        try {
            return (Number)idType.getMethod("valueOf", String.class).invoke(null, id.toString());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("fail to invoke valueOf to generator concrete type id");
        }
    }
    
    protected List<?> getParamValues(List<? extends Parameter<?>> params) {
        if((params == null) || params.isEmpty()) {
            return Collections.emptyList();
        }
        
        return params.stream().map(Parameter::getValue).collect(Collectors.toList());
    }
    
    protected <T> void insert(T model, Insert<T> insert) {
        if((model == null) || (insert == null)) {
            throw new NullPointerException(String.format("model is %s, insert is %s", model, insert));
        }
        
        Number id = insertForLongId(jtm, insert.create(), getParamValues(insert.getParams(model)));
        
        if(id != null) {
           if(!Number.class.isAssignableFrom(insert.getIdType())) {
               throw new IdTypeMismatchException(insert.getDomainType(), insert.create(), insert.getIdType());
           } 
           
           Number concreteTypeId = resolveId(id, insert.getIdType());
           insert.saveId(model, concreteTypeId);
        }
    }
    
    protected <T> void insert(List<T> models, Insert<T> insert) {
        if((models == null) || models.isEmpty()) {
            throw new IllegalArgumentException("models is " + models);
        }
        
        List<? extends List<?>> argsList = models.stream().map(t -> getParamValues(insert.getParams(t)))
                                                          .collect(Collectors.toList());
        
        List<? extends Number> ids = batchInsert(jtm, insert.create(), argsList);
        
        if(!ids.isEmpty()) {
            if(!Number.class.isAssignableFrom(insert.getIdType())) {
                throw new IdTypeMismatchException(insert.getDomainType(), insert.create(), insert.getIdType());
            } 
            
            if(ids.size() != models.size()) {
                throw new AssertionError();
            }
            
            for(int i = 0; i < ids.size(); ++i) {
                Number concreteTypeId = resolveId(ids.get(i), insert.getIdType());
                insert.saveId(models.get(i), concreteTypeId);
            }
        }
    }
    
    protected <U> U queryForSimpleObject(Query<U> query) {
        return jtm.queryForObject(query.create(), getParamValues(query.getParams()).toArray(), query.getResultType());
    }
    
    protected <U> U queryForBeanObject(Query<U> query) {
        return jtm.queryForObject(query.create(), getParamValues(query.getParams()).toArray(), 
                CustomBeanPropertyRowMapper.newInstance(query.getResultType()));
    }
    
    protected <U> List<U> queryForSimpleList(Query<U> query) {
        return jtm.queryForList(query.create(), query.getResultType(), getParamValues(query.getParams()).toArray());
    }
    
    protected <U> List<U> queryForBeanList(Query<U> query) {
        return jtm.query(query.create(), getParamValues(query.getParams()).toArray(), 
                CustomBeanPropertyRowMapper.newInstance(query.getResultType()));
    }
    
    protected <T> int update(Update<T> update) {
        return jtm.update(update.create(), getParamValues(update.getParams()).toArray());
    }
    
    public static Number insertForLongId(JdbcTemplate jtm, final String sql,
            final List<?> args) {
        KeyHolder holder = new GeneratedKeyHolder();
        int count = jtm.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < args.size(); i++) {
                    ps.setObject(i + 1, args.get(i));
                }
                return ps;
            }
        }, holder);
       
        if(count != 1) {
            throw new InsertException(sql, args);
        }
        
        return holder.getKey();
    }
    
    public static List<? extends Number> batchInsert(JdbcTemplate jtm, final String sql, final List<? extends List<?>> argsList) {
        List<Long> retList = new ArrayList<Long>();
        Connection connection = DataSourceUtils.getConnection(jtm.getDataSource());
        try(PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            for(int i= 0; i < argsList.size(); i++){   
                List<?> args = argsList.get(i);
                for(int j = 0; j < args.size(); ++j) {
                    ps.setObject(j + 1, args.get(j));
                }
                ps.addBatch();
             }
            int[] result = ps.executeBatch();
            
            for(int i = 0; i < result.length; ++i) {
                int r = result[i];
                if((r != 1) && (r != Statement.SUCCESS_NO_INFO)) {
                    throw new InsertException(sql, argsList.get(i));
                }
            }
            
            ResultSet rst = ps.getGeneratedKeys();
            while(rst.next()){
                retList.add(rst.getLong(1));
            }
        } catch(SQLException sqlException) {
            throw new RuntimeException(sqlException);
        } finally {
            DataSourceUtils.releaseConnection(connection, jtm.getDataSource());
        }
        
        return retList;
    }
}
