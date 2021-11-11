package com.charlie.classdemo;

import com.charlie.Car;

import java.lang.reflect.Field;

/**
 * Class methods demonstration
 *
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Class02 {
    public static void main(String[] args) throws Exception {
        String classFullPath = "com.charlie.Car";
        //get Car's Class instance, <?> represent not sure type
        Class<?> carClass = Class.forName(classFullPath);

        //output carClass
        System.out.println(carClass);   //class com.charlie.Car
        System.out.println(carClass.getClass());    //running type: java.lang.Class

        //get package name
        Package aPackage = carClass.getPackage();
        System.out.println(aPackage.getName());   //com.charlie

        //get full class name
        String name = carClass.getName();
        System.out.println(name);   //com.charlie.Car

        //create instance of class
        Object o = carClass.newInstance();
        Car car = (Car) o;
        System.out.println(car);

        //get attribute by reflection
        Field brand = carClass.getField("brand");
        /*
        out put brand info
        attention: can not get private attribute
         */
        System.out.println(brand.get(car));

        //set attributes value through reflection
        brand.set(car, "BMW");
        System.out.println(brand.get(car));

        //get all attributes
        Field[] fields = carClass.getFields();
        for (Field field : fields) {
            System.out.println(field.get(car));
        }

    }
}
