package com.moon.base.basic.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 从持久的文件中读取Bytes重建对象，我们可以使用ObjectInputStream。
 * 
 * @author TobiasCui
 * @date 2018年11月12日 下午3:52:18
 * 
 */
public class Deserialization {

	public static void main(String[] args) throws Exception {
		FileInputStream fos = new FileInputStream("temp.out");
		ObjectInputStream oos = new ObjectInputStream(fos);
		TestSerializable ts = new TestSerializable();
		ts = (TestSerializable) oos.readObject();
		System.out.println(ts.version);
	}

}
