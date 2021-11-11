package com.charlie.classdemo;

import com.charlie.Car;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * demonstrate ways to get Class object
 *
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class GetClassDemo {
    public static void main(String[] args) throws Exception {
        /*
        1.forName()
        precondition is have class full path
        such as there is properties config file
         */
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.getProperty("classfullpath");
        Class<?> cls = Class.forName(classFullPath);    //get Class object
        System.out.println(cls);

        /*
        2.ClassName.class
        to pass the parameters
         */
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        /*
        3.Instance.getClass()
        get Class obj by specific instance of some class
         */
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        /*
        4.ClassLoader(4 types)
        ClassLoader.loadClass("classFullPath")
         */
        //(1)get ClassLoader
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)get Class obj
        Class<?> cls4 = classLoader.loadClass("com.charlie.Car");
        System.out.println(cls4);

        /*
        elementary data type and packaging class
         */
        Class<Byte> byteClass = byte.class;
        Class<Short> shortClass = short.class;
        Class<Integer> integerClass = int.class;
        Class<Float> floatClass = float.class;
        Class<Long> longClass = long.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;

        System.out.println(integerClass);   //int

        Class<Integer> intType = Integer.TYPE;
        System.out.println(intType);    //int

        System.out.println(integerClass.equals(intType));   //true
        System.out.println(integerClass.hashCode());
        System.out.println(intType.hashCode());

        Class<Character> charType = Character.TYPE;
        System.out.println(charType);   //char

    }
}
