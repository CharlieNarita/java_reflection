package com.charlie.classdemo;

/**
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Class01 {
    public static void main(String[] args) throws Exception {
        /*
        Class is extends from Object
        Class instance is created by system
         */
        /*
        1.traditional way to new an instance
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */
        //Cat cat = new Cat();

        /*
        2.reflection way
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         */
        Class<?> cls = Class.forName("com.charlie.Cat");

        /*
        3.there is just one Class instance in the heap RAM
        the Class just loaded once time
         */
        Class<?> cls2 = Class.forName("com.charlie.Cat");
        //two Class instance have same hashcode
        System.out.println(cls.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls == cls2); //true

        Class<?> dogClass = Class.forName("com.charlie.Dog");
        System.out.println(dogClass.hashCode());
    }
}
