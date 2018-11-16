package com.moon.base.basic.map;

import java.io.IOException;
import java.util.IdentityHashMap;

/**
 * 如果需要使用WeakHashMap的key来保留对象的弱引用，则不要让key所引用的对象具有任何强引用，否则将失去使用WeakHashMap的意义 <br>
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class IdentityHashMapTest {
    public static void main(String[] args) throws IOException {
        IdentityHashMap ihm = new IdentityHashMap();
        //下面两行代码将会向IdentityHashMap对象中添加两个key-value对
        ihm.put(new String("语文") , 89);
        ihm.put(new String("语文") , 78);

        //下面两行代码只会向IdentityHashMap对象中添加一个key-value对
        ihm.put("java" , 93);
        ihm.put("java" , 98);
        System.out.println(ihm);
    }
}
