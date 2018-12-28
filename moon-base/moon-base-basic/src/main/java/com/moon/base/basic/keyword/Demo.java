package com.moon.base.basic.keyword;

/**
 * java 中的instanceof
 * 运算符是用来在运行时指出对象是否是特定类的一个实例。instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
 * 
 * @author Tobias
 * @date 2018年12月16日 下午8:47:24
 * 
 */
public class Demo {

	public static void main(String[] args) {
		Man man = new Man();
		XiaoCui xiaoCui = new XiaoCui();
		System.out.println(man instanceof Person);
		System.out.println(man instanceof Man);
		System.out.println(man instanceof XiaoCui);
		System.out.println(man instanceof Person);
		System.out.println(xiaoCui instanceof Man);
		System.out.println(xiaoCui instanceof Person);
	}

}

class Person {

}

class Man extends Person {

}

class XiaoCui extends Man {

}
