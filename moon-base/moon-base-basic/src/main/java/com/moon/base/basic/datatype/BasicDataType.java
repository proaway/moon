package com.moon.base.basic.datatype;

import java.lang.reflect.Field;

public class BasicDataType {

    public static void main(String[] args) {
        Integer num1=1;
        Integer num2=2;
        swap(num1,num2);
        System.out.println(num1);

        System.out.println(num2);
    }
    /**
     * 自动装箱拆箱
     * 反射
     * 整数缓存
     */
    private static void swap(Integer num1, Integer num2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = num1.intValue();
            field.set(num1, num2);
            field.set(num2, new Integer(tmp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
