package com.moon.base.basic.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties还可以把key-value对以XML文件的形式保存起来，也可以从XML文件中加载key-value对<br>
 *
 * @author TobiasCui
 * @create 2018/11/14
 * @since 1.0.0
 */
public class PropertiesTest {


    public static void main(String[] args) throws IOException {

        Properties props = new Properties();
        //向Properties中增加属性
        props.setProperty("username", "yeeku");
        props.setProperty("password", "123456");

        //将Properties中的key-value对保存到a.ini文件中
        props.store(new FileOutputStream("a.ini"), "comment line");   //①

        //新建一个Properties对象
        Properties props2 = new Properties();
        //向Properties中增加属性
        props2.setProperty("gender", "male");

        //将a.ini文件中的key-value对追加到props2中
        props2.load(new FileInputStream("a.ini"));    //②
        System.out.println(props2);
    }
}
