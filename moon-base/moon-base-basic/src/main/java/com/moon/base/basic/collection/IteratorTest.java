package com.moon.base.basic.collection;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 我们之前说过，Collection接口继承了Iterable接口，也就是说，我们以上学习到的所有的Collection集合类都具有"可遍历性"
 * <p>
 * Iterable接口也是java集合框架的成员，它隐藏了各种Collection实现类的底层细节，向应用程序提供了遍历Collection集合元素的统一编程接口: <br>
 * <p>
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class IteratorTest {
    public static void main(String[] args) {
        //创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        //获取books集合对应的迭代器
        Iterator it = books.iterator();
        while (it.hasNext()) {
            //it.next()方法返回的数据类型是Object类型，
            //需要强制类型转换
            String book = (String) it.next();
            System.out.println(book);
            if (book.equals("疯狂Java讲义")) {
                //从集合中删除上一次next方法返回的元素
                it.remove();
            }
            //对book变量赋值，不会改变集合元素本身
            book = "测试字符串";
        }
        System.out.println(books);
        System.out.println("+++++++++++++++++++++++++");
        for (Object obj : books) {
            //此处的book变量也不是集合元素本身
            String book = (String) obj;
            System.out.println(book);
            if (book.equals("疯狂Android讲义")) {
                //下面代码会引发ConcurrentModificationException异常
                //books.remove(book);
            }
        }
        System.out.println(books);

    }
}
