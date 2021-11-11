package com.charlie.classdemo;

import java.io.Serializable;

/**
 * @author AC
 * @version 1.0
 */
public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;   //out class

        Class<Serializable> serializableClass = Serializable.class; //interface

        Class<Integer[]> aClass = Integer[].class;

        Class<float[][]> aClass1 = float[][].class;

        Class<Deprecated> deprecatedClass = Deprecated.class;   //annotation

        //Enum
        Class<Thread.State> stateClass = Thread.State.class;

        Class<Long> longClass = long.class;

        Class<Character> characterClass = Character.class;

        Class<Void> voidClass = void.class;

        Class<Class> classClass = Class.class;
        System.out.println(classClass);

    }
}
