package com.moon.base.basic.proxy.cglib;

public class CglibTest {
	public static void main(String[] args) {
		AddService add = (AddService) new CGlibInterceptor().getInstance(AddService.class);
		add.add();
	}
}
