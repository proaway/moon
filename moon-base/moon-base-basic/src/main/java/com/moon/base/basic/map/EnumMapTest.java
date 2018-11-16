package com.moon.base.basic.map;

import java.io.IOException;
import java.util.EnumMap;
import java.util.WeakHashMap;

/**
 * 与创建普通Map有所区别的是，创建EnumMap是必须指定一个枚举类，从而将该EnumMap和指定枚举类关联起来 <br>
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class EnumMapTest {
    public static void main(String[] args) throws IOException {
        //创建一个EnumMap对象，该EnumMap的所有key
        //必须是Season枚举类的枚举值
        EnumMap enumMap = new EnumMap(Season.class);
        enumMap.put(Season.SUMMER , "夏日炎炎");
        enumMap.put(Season.SPRING , "春暖花开");
        System.out.println(enumMap);
    }
}

enum Season {
    SPRING,SUMMER,FALL,WINTER
}