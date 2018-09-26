package com.moon.base.basic.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// 代理类调用父类的方法
		proxy.invokeSuper(obj, args);
		return null;
	}

	/**
	 * 获取代理对象的实例
	 * 
	 * @author TobiasCui
	 * @date 2018年9月25日 下午4:56:04
	 * 
	 * @param clazz
	 *            代理中生成子类的继承类
	 * @return
	 */
	public Object getInstance(Class clazz) {
		// 通过enhancer创建代理对象
		Enhancer enhancer = new Enhancer();
		// 1. 将要生成的子类需要继承的是哪个类
		enhancer.setSuperclass(clazz);
		// 设置回调
		enhancer.setCallback(this);
		// 一、生成源码；
		// 二、编译成class文件；
		// 三、加载到jvm中，并返回代理对象
		return enhancer.create();
	}

}
