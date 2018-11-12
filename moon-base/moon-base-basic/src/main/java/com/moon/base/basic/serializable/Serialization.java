package com.moon.base.basic.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 将对象序列化并输出。ObjectOutputStream能把Object输出成Byte流。 我们将Byte流暂时存储到temp.out文件里。
 * 
 * @author TobiasCui
 * @date 2018年11月12日 下午3:52:18
 * 
 */
public class Serialization {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("temp.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerializable ts = new TestSerializable();
		oos.writeObject(ts);
		oos.flush();
		oos.close();
	}

}

