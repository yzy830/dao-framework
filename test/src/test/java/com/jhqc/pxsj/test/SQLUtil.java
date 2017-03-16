package com.jhqc.pxsj.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class SQLUtil {

	/**
	 * 插入记录返回自增int型id
	 * @param jtm
	 * @param sql
	 * @param args
	 * @return
	 */
	public static int insertForIntId(JdbcTemplate jtm, final String sql,
			final Object... args) {
		KeyHolder holder = new GeneratedKeyHolder();
		jtm.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				return ps;
			}
		}, holder);
		checkKeyNull(holder.getKey(), sql);
		return holder.getKey().intValue();
	}

	/**
	 * 插入记录返回自增long型id
	 * @param jtm
	 * @param sql
	 * @param args
	 * @return
	 */
	public static long insertForLongId(JdbcTemplate jtm, final String sql,
			final Object... args) {
		KeyHolder holder = new GeneratedKeyHolder();
		jtm.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql,
						PreparedStatement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				return ps;
			}
		}, holder);
		checkKeyNull(holder.getKey(), sql);
		return holder.getKey().longValue();
	}

	/**
	 * 查询多条记录返回list
	 * @param jtm
	 * @param sql
	 * @param type
	 * @param args
	 * @return
	 */
	public static <T> List<T> queryForList(JdbcTemplate jtm, String sql,
			Class<T> type, Object... args) {
		return jtm.query(sql, new BeanPropertyRowMapper<T>(type), args);
	}

	
	/**
	 * 查询单条记录，若没有记录则返回null
	 * @param jtm
	 * @param sql
	 * @param type
	 * @param args
	 * @return
	 */
	public static <T> T queryForObject(JdbcTemplate jtm, String sql,Class<T> type, Object... args) {
		try {
			return jtm.queryForObject(sql, new BeanPropertyRowMapper<T>(type),args);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	private static void checkKeyNull(Number key,String sql) {
		if (key == null) {
			throw new RuntimeException("no primary key,sql:" + sql);
		}
	}

}
