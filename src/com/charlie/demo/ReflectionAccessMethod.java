package com.charlie.demo;

import java.lang.reflect.Method;

/**
 * @author AC
 * @version 1.0
 */
public class ReflectionAccessMethod {
    public static void main(String[] args) throws Exception {
        //1.get Boss Class object
        Class<?> cls = Class.forName("com.charlie.demo.Boss");

        //2.create instance of Boss
        Object o = cls.newInstance();

        //3.invoke public method
        Method hello = cls.getDeclaredMethod("hello", String.class);
        hello.invoke(o, "Java");

        //4.invoke private static method
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        Object invoke = say.invoke(null, 123, "haha", 'K');
        System.out.println(invoke.getClass());//running type is String

        String str = (String) invoke;
        System.out.println(str);
    }
}

class Boss {
    private static String name;
    public int age;

    public Boss() {

    }

    private static String say(int n, String s, char c) {
        return n + "" + s + "" + c;
    }

    public void hello(String s) {
        System.out.println("hello " + s);
    }
}
