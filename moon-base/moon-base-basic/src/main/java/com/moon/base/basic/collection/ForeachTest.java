package com.moon.base.basic.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 使用iterator接口迭代访问Collection集合里的元素之外，使用java5提供的foreach循环迭代访问集合元素更加便捷
 * <p>
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class ForeachTest {
    public static void main(String[] args) {
        //创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        for (Object obj : books) {
            //此处的book变量也不是集合元素本身
            String book = (String) obj;
            System.out.println(book);
            if (book.equals("疯狂Android讲义")) {
                //下面代码会引发ConcurrentModificationException异常
                books.remove(book);
            }
        }
        System.out.println(books);
    }
}
