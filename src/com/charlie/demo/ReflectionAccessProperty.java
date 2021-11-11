package com.charlie.demo;

import java.lang.reflect.Field;

/**
 * @author AC
 * @version 1.0
 */
public class ReflectionAccessProperty {
    public static void main(String[] args) throws Exception {
        //1.get Student Class obj
        Class<?> cls = Class.forName("com.charlie.demo.Student");

        //2.create Student instance
        Object o = cls.newInstance();   //o running type is Student

        //3.set age by reflection
        Field age = cls.getField("age");
        age.set(o, 999);
        System.out.println(o);
        System.out.println(age.get(o));

        //4.set name by reflection
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null, "M-16");
        System.out.println(o);
        System.out.println(name.get(o));    //common pass obj
        System.out.println(name.get(null)); //only static pass null
    }
}

class Student {
    private static String name;
    public int age;

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name=" + name +
                '}';
    }
}
