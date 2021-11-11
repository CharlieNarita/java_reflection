package com.charlie;

/**
 * @author AC
 * @version 1.0
 */
public class Cat {
    private String name = "japan cat";
    public int age = 3;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello " + name);
    }

    public void eat() {
        System.out.println(name + " eat fish");
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
