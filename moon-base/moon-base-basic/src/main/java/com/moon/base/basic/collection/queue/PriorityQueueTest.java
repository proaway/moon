package com.moon.base.basic.collection.queue;

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
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        //下面代码依次向pq中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(9);
        pq.offer(0);

        //输出pq队列，并不是按元素的加入顺序排列，
        //而是按元素的大小顺序排列，输出[-3, 0, 9, 6]
        System.out.println(pq);
        //访问队列第一个元素，其实就是队列中最小的元素：-3
        System.out.println(pq.poll());
    }
}
