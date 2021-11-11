package com.charlie.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author AC
 * @version 1.0
 */
public class Practice01 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.charlie.demo.PrivateTest");
        Object o = cls.newInstance();

        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "helloWorld");

        Method getName = cls.getDeclaredMethod("getName");
        Object ptName = getName.invoke(o);
        System.out.println("PrivateTest name = " + ptName);
    }
}

class PrivateTest {
    private String name = "helloJava";

    public String getName() {
        return name;
    }
}
