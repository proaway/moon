package com.moon.base.basic.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 除了Collection固有的iterator()方法，List还额外提供了一个listIterator()方法，该方法返回一个ListIterator对象，
 * ListIterator接口继承了Iterator接口，提供了专门操作List的方法。ListIterator接口在Iterator接口的继承上增加了如下方法:
 * <p>
 * 1) boolean hasPrevious(): 返回该迭代器关联的集合是否还有上一个元素
 * 2) Object previous(): 返回该迭代器的上一个元素(向前迭代)
 * 3) void add(): 在指定位置插入一个元素
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
                "疯狂Java讲义",
                "轻量级Java EE企业应用实战"
        };
        List bookList = new ArrayList();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }
        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("-------分隔符-------");
        }
        System.out.println("=======下面开始反向迭代=======");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
    }
}
