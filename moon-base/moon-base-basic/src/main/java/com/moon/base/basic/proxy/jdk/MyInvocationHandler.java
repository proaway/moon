package com.moon.base.basic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * {@code MyInvocationHandler} implementes {@code InvocationHandler} Interface.
 * <p>
 * {@code InvocationHandler} is the interface implemented by the <i>invocation
 * handler</i> of a proxy instance.
 *
 * <p>
 * Each proxy instance has an associated invocation handler. When a method is
 * invoked on a proxy instance, the method invocation is encoded and dispatched
 * to the {@code invoke} method of its invocation handler.
 * 
 * @author TobiasCui
 * @date 2018年9月25日 下午3:08:35
 * 
 */
public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	/*
	 * 执行目标对象的方法
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 执行目标对象的方法
		Object result = method.invoke(target, args);
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}

}
