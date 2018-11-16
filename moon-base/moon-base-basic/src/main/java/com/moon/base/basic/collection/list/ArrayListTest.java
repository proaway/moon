package com.moon.base.basic.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈如果一开始就知道ArrayList集合需要保存多少元素，则可以在创建它们时就指定initialCapacity大小，这样可以减少重新分配的次数，提供性能，ArrayList还提供了如下方法来重新分配Object[]数组〉
 * 1) ensureCapacity(int minCapacity): 将ArrayList集合的Object[]数组长度增加minCapacity
 * 2) trimToSize(): 调整ArrayList集合的Object[]数组长度为当前元素的个数。程序可以通过此方法来减少ArrayList集合对象占用的内存空间
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List books = new ArrayList();
        //向books集合中添加三个元素
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂Android讲义"));
        System.out.println(books);
        System.out.println("------------------");


        //将新字符串对象插入在第二个位置
        books.add(1, new String("疯狂Ajax讲义"));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println("------------------");
        //删除第三个元素
        books.remove(2);
        System.out.println(books);
        System.out.println("------------------");
        //判断指定元素在List集合中位置：输出1，表明位于第二位
        System.out.println(books.indexOf(new String("疯狂Ajax讲义")));  //①
        System.out.println("------------------");

        //将第二个元素替换成新的字符串对象
        books.set(1, new String("Hello Java!"));
        System.out.println(books);
        System.out.println("------------------");

        //将books集合的第二个元素（包括）
        //到第三个元素（不包括）截取成子集合
        System.out.println(books.subList(1, 2));
    }
}
