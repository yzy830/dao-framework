package com.jhqc.pxsj.test.config;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mysql.jdbc.log.Log;

public class MySqlLogger implements Log {
	
	protected Logger logger = null;
	
	public MySqlLogger(String name) {
		logger = LogManager.getLogger(name);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isEnabledFor(Level.ERROR);
	}

	@Override
	public boolean isFatalEnabled() {
		return logger.isEnabledFor(Level.FATAL);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
	    return logger.isEnabledFor(Level.WARN);
	}

	@Override
	public void logDebug(Object msg) {
		logger.debug(msg);
	}

	@Override
	public void logDebug(Object msg, Throwable thrown) {
		logger.debug(msg, thrown);
	}

	@Override
	public void logError(Object msg) {
		logger.error(msg);
	}

	@Override
	public void logError(Object msg, Throwable thrown) {
		logger.error(msg, thrown);
	}

	@Override
	public void logFatal(Object msg) {
		logger.fatal(msg);
	}

	@Override
	public void logFatal(Object msg, Throwable thrown) {
		logger.fatal(msg, thrown);
	}

	@Override
	public void logInfo(Object msg) {
		logger.info(msg);
	}

	@Override
	public void logInfo(Object msg, Throwable thrown) {
		logger.info(msg, thrown);
	}

	@Override
	public void logTrace(Object msg) {
		logger.trace(msg);
	}

	@Override
	public void logTrace(Object msg, Throwable thrown) {
		logger.trace(msg, thrown);
	}

	@Override
	public void logWarn(Object msg) {
		logger.warn(msg);
	}

	@Override
	public void logWarn(Object msg, Throwable thrown) {
		logger.warn(msg, thrown);
	}
}
