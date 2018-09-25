package com.moon.base.basic.proxy.jdk;

public class JDKProxyTest {
	public static void main(String[] args) {
		IService service = new IServiceImpl();
		MyInvocationHandler invocationHandler = new MyInvocationHandler(service);

		IService proxy = (IService) invocationHandler.getProxy();
		proxy.add();
	}
}
