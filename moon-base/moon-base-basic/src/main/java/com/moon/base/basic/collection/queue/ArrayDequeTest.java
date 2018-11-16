package com.moon.base.basic.collection.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * PriorityQueue不允许插入null元素，它还需要对队列元素进行排序，PriorityQueue的元素有两种排序方式 <br>
 * <p>
 * 1) 自然排序:
 * 采用自然顺序的PriorityQueue集合中的元素对象都必须实现了Comparable接口，而且应该是同一个类的多个实例，否则可能导致ClassCastException异常
 * 2) 定制排序
 * 创建PriorityQueue队列时，传入一个Comparator对象，该对象负责对队列中的所有元素进行排序
 * 关于自然排序、定制排序的原理和之前说的TreeSet类似
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        //依次将三个元素push入"栈"
        stack.push("疯狂Java讲义");
        stack.push("轻量级Java EE企业应用实战");
        stack.push("疯狂Android讲义");

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(stack);

        //访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
        System.out.println(stack.peek());

        //依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(stack);

        //pop出第一个元素，输出：疯狂Android讲义
        System.out.println(stack.pop());

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
        System.out.println(stack);
    }
}
