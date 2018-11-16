package com.moon.base.basic.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet支持两种排序方式: 自然排序、定制排序 <br>
 * 1) equals、compareTo决定的是怎么比的问题，即用什么field进行大小比较
 * 2) 自然排序、定制排序，Comparator决定的是谁大的问题，即按什么顺序(升序、降序)进行排序
 * 它们的关注点是不同的，一定要注意区分
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class TreeSetTestSort {
    public static void main(String[] args) {
        TreeSet treeSetM = new TreeSet(new Comparator() {
            //根据M对象的age属性来决定大小
            public int compare(Object o1, Object o2) {
                M m1 = (M) o1;
                M m2 = (M) o2;
                return m1.age > m2.age ? -1
                        : m1.age < m2.age ? 1 : 0;
            }
        });
        treeSetM.add(new M(3));
        treeSetM.add(new M(5));
        treeSetM.add(new M(-3));
        treeSetM.add(new M(-6));
        treeSetM.add(new M(9));
        System.out.println(treeSetM);
    }
}

class M {
    int age;

    public M(int age) {
        this.age = age;
    }

    public String toString() {
        return "M[age:" + age + "]";
    }
}
