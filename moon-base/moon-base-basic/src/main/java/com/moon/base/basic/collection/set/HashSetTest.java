package com.moon.base.basic.collection.set;

import java.util.HashSet;

/**
 * 〈功能简述〉<br>
 * 〈Demo Of HashSet〉
 * 如果两个对象通过equals()方法比较返回true，但这两个对象的hashCode()方法返回不同的hashCode值时，这将导致HashSet会把这两个对象保存在Hash表的不同位置，从而使对象可以添加成功，这就与Set集合的规则有些出入了。
 * <p>
 * 所以，我们要明确的是: equals()决定是否可以加入HashSet，而hashCode()决定存放的位置，它们两者必须同时满足才能允许一个新元素加入HashSet。
 * 但是要注意的是: 如果两个对象的hashCode相同，但是它们的equlas返回值不同，HashSet会在这个位置用链式结构来保存多个对象。而HashSet访问集合元素时也是根据元素的HashCode值来快速定位的，这种链式结构会导致性能下降。
 * <p>
 * 所以如果需要把某个类的对象保存到HashSet集合中，我们在重写这个类的equlas()方法和hashCode()方法时，应该尽量保证两个对象通过equals()方法比较返回true时，它们的hashCode()方法返回值也相等
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet books = new HashSet();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());

        books.add(new B());
        books.add(new B());

        books.add(new C());
        books.add(new C());
        System.out.println(books);
    }
}

/**
 * 类A的equals方法总是返回true,但没有重写其hashCode()方法。
 * <p>
 * 不能保证当前对象是HashSet中的唯一对象
 */
class A {
    public boolean equals(Object obj) {
        return true;
    }
}

/**
 * 类B的hashCode()方法总是返回1,但没有重写其equals()方法。
 * <p>
 * 不能保证当前对象是HashSet中的唯一对象
 */
class B {
    public int hashCode() {
        return 1;
    }
}

//类C的hashCode()方法总是返回2,且有重写其equals()方法
class C {
    public int hashCode() {
        return 2;
    }

    public boolean equals(Object obj) {
        return true;
    }
}
