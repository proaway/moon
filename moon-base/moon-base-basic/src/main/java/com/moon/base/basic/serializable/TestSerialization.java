package com.moon.base.basic.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 从持久的文件中读取Bytes重建对象，我们可以使用ObjectInputStream。
 * 
 * @author TobiasCui
 * @date 2018年11月12日 下午3:52:18
 * 
 */
public class TestSerialization {
	private static final long serialVersionUID = 1L;
	public static int staticVar = 5;

	public static void main(String[] args) {
		try {
			// 初始时staticVar为5
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
			out.writeObject(new TestSerialization());
			out.close();

			// 序列化后修改为10
			TestSerialization.staticVar = 10;

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("resule.obj"));
			TestSerialization t = (TestSerialization) oin.readObject();
			oin.close();

			// 再读取，通过t.staticVar打印新值
			System.out.print(t.staticVar);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}