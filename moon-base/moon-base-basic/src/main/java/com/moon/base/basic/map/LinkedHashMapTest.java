package com.moon.base.basic.map;

import java.util.Hashtable;
import java.util.LinkedHashMap;

/**
 * 〈功能简述〉<br>
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class LinkedHashMapTest {


    public static void main(String[] args) {
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("英文", 82);
        scores.put("数学", 76);
        //遍历scores里的所有的key-value对
        for (Object key : scores.keySet()) {
            System.out.println(key + "------>" + scores.get(key));
        }
    }
}
