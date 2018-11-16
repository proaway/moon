package com.moon.base.basic.collection.set;

import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * 〈功能简述〉<br>
 * 与HashSet集合采用hash算法来决定元素的存储位置不同，TreeSet采用红黑树的数据结构来存储集合元素。
 * <p>
 * TreeSet支持两种排序方式: 自然排序、定制排序
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSetNums = new TreeSet();
        //向TreeSet中添加四个Integer对象
        treeSetNums.add(5);
        treeSetNums.add(2);
        treeSetNums.add(10);
        treeSetNums.add(-9);
        //输出集合元素，看到集合元素已经处于排序状态
        System.out.println(treeSetNums);
        //输出集合里的第一个元素
        System.out.println(treeSetNums.first());
        //输出集合里的最后一个元素
        System.out.println(treeSetNums.last());
        //返回小于4的子集，不包含4
        System.out.println(treeSetNums.headSet(4));
        //返回大于5的子集，如果Set中包含5，子集中还包含5
        System.out.println(treeSetNums.tailSet(5));
        //返回大于等于-3，小于4的子集。
        System.out.println(treeSetNums.subSet(-3, 4));
    }
}
