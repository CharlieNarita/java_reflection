package com.charlie.demo;


import com.charlie.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * test reflection performance and optimization
 *
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
    }

    //traditional way call method
    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000; i++) {
            cat.hello();
        }
        long end = System.currentTimeMillis();
        System.out.println("traditional way time = " + (end - start));
    }

    //reflection way call method
    public static void m2() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");

        Class<?> cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method hello = cls.getMethod("hello");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000; i++) {
            hello.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("reflection way time = " + (end - start));
    }

    /**
     * reflection optimization:
     * Set the accessible flag for this object to the indicated boolean value.
     * A value of true indicates that the reflected object should suppress Java language access checking when it is used.
     * A value of false indicates that the reflected object should enforce Java language access checks.
     *
     * @throws Exception
     */
    public static void m3() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");

        Class<?> cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method hello = cls.getMethod("hello");
        //setAccessible(true) can improve the efficiency of reflection
        hello.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000; i++) {
            hello.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("reflection way time = " + (end - start));
    }
}
