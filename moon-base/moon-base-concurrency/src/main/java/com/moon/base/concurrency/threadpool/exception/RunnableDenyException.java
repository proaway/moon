package com.moon.base.concurrency.threadpool.exception;

/**
 * 自定义异常
 * 
 * @author Tobias
 * @date 2018年10月21日 下午11:37:55
 * 
 */
public class RunnableDenyException extends RuntimeException {
	public RunnableDenyException(String message) {
		super(message);
	}
}
