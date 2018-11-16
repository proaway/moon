##Map集合类的编程应用场景
1. HashMap和Hashtable的效率大致相同，因为它们的实现机制几乎完全一样：
    但HashMap通常比Hashtable要快一点，因为Hashtable需要额外的线程同步控制
2. TreeMap通常比HashMap、Hashtable要慢(尤其是在插入、删除key-value对时更慢)，因为TreeMap底层采用红黑树来管理key-value对
3. 使用TreeMap的一个好处就是： TreeMap中的key-value对总是处于有序状态，无须专门进行排序操作