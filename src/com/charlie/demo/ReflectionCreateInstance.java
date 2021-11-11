package com.charlie.demo;

import java.lang.reflect.Constructor;

/**
 * demonstrate create instance through reflection
 *
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception {
        //1.get User Class obj
        Class<?> cls = Class.forName("com.charlie.demo.User");

        //2.create User instance through public non-parameter constructor
        Object o = cls.newInstance();   //default constructor
        System.out.println(o.toString());

        //3.create User instance through public parameter constructor
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("AKM");
        System.out.println(o1.toString());

        //4.create User instance through no-public parameter constructor
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(String.class, int.class);
        //visit private constructor by setAccessiable(true)
        declaredConstructor.setAccessible(true);
        Object o2 = declaredConstructor.newInstance("AR-15", 15);
        System.out.println(o2.toString());
    }
}

class User {
    private String name = "U-2";
    private int age = 12;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    private User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
