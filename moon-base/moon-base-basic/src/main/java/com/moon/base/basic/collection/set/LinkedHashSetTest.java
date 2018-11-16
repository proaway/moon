package com.moon.base.basic.collection.set;

import java.util.LinkedHashSet;

/**
 * 〈功能简述〉<br>
 * 元素的顺序总是与添加顺序一致，同时要明白的是，LinkedHashSetTest是HashSet的子类，因此它不允许集合元素重复
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("Java");
        books.add("C++");
        System.out.println(books);
        //删除 Java
        books.remove("Java");
        //重新添加 Java
        books.add("Java");
        System.out.println(books);
    }
}
