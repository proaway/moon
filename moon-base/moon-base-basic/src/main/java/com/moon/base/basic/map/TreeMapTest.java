package com.moon.base.basic.map;

import java.io.IOException;
import java.util.TreeMap;

/**
 * 从代码中可以看出，类似于TreeSet中判断两个元素是否相等的标准，TreeMap中判断两个key相等的标准是: <br>
 * 1) 两个key通过compareTo()方法返回0
 * 2) equals()放回true
 * 我们在重写这两个方法的时候一定要保证它们的逻辑关系一致。
 *
 * 再次强调一下:Set和Map的关系十分密切，java源码就是先实现了HashMap、TreeMap等集合，
 * 然后通过包装一个所有的value都为null的Map集合实现了Set集合类
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class TreeMapTest {
    public static void main(String[] args) throws IOException {
        TreeMap tm = new TreeMap();
        tm.put(new R(3), "轻量级Java EE企业应用实战");
        tm.put(new R(3), "轻量级Java SE企业应用实战");
        tm.put(new R(-5), "疯狂Java讲义");
        tm.put(new R(9), "疯狂Android讲义");

        System.out.println(tm);

        //返回该TreeMap的第一个Entry对象
        System.out.println(tm.firstEntry());

        //返回该TreeMap的最后一个key值
        System.out.println(tm.lastKey());

        //返回该TreeMap的比new R(2)大的最小key值。
        System.out.println(tm.higherKey(new R(2)));

        //返回该TreeMap的比new R(2)小的最大的key-value对。
        System.out.println(tm.lowerEntry(new R(2)));

        //返回该TreeMap的子TreeMap
        System.out.println(tm.subMap(new R(-1), new R(4)));
    }
}

class R implements Comparable {
    int count;

    public R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R[count:" + count + "]";
    }

    //根据count来判断两个对象是否相等。
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null
                && obj.getClass() == R.class) {
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

    //根据count属性值来判断两个对象的大小。
    public int compareTo(Object obj) {
        R r = (R) obj;
        return count > r.count ? 1 :
                count < r.count ? -1 : 0;
    }
}

