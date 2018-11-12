package com.moon.base.basic.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 一个对象能够序列化的前提是实现Serializable接口，Serializable接口没有方法，更像是个标记。
 * 有了这个标记的Class就能被序列化机制处理。
 * 
 * @author TobiasCui
 * @date 2018年11月12日 下午3:48:59
 * 
 */
public class TestSerializable extends Parent implements java.io.Serializable {
	int version = 66;
	Container con = new Container();

	public int getVersion() {
		return version;
	}

	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerializable st = new TestSerializable();
		oos.writeObject(st);
		oos.flush();
		oos.close();
	}
}

class Parent implements Serializable {
	int parentVersion = 10;
}

class Container implements Serializable {
	int containVersion = 11;
}
