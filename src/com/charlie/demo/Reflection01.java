package com.charlie.demo;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));

        //get class full path name and method name
        String classFullPathName = properties.getProperty("classfullpath");
        String methodName = properties.getProperty("method");
        System.out.println("classfullpath = " + classFullPathName);
        System.out.println("method = " + methodName);

        //use reflection
        //1.load class, return a Class type variable
        Class<?> cls = Class.forName(classFullPathName);

        //2.get com.charlie.Cat instance through variable cls
        Object o = cls.newInstance();
        //running type is Cat
        System.out.println(o.getClass());

        /*
        3.get Method instance through method name
        methods can be class Method instance in reflection
         */
        Method method = cls.getMethod(methodName);

        //4.invoke
        method.invoke(o);

        /*
        attention: getFiled cannot get private field
        Field name = cls.getField("name");
         */
        Field ageField = cls.getField("age");

        /*
        traditional format:
        instance.memberVariable
        instance.memberMethod
        reflection format:
        filedObj.get(instance)
         */
        Object o1 = ageField.get(o);
        System.out.println("age = " + o1);

        /*
        getConstructor() return no parameter constructor
        getConstructor() return constructor with parameter

        Returns a Constructor object that reflects the specified public constructor of the class represented by this Class object.
        The parameterTypes parameter is an array of Class objects that identify the constructor's formal parameter types, in declared order.
        If this Class object represents an inner class declared in a non-static context, the formal parameter types include the explicit enclosing instance as the first parameter.
        The constructor to reflect is the public constructor of the class represented by this Class object whose formal parameter types match those specified by parameterTypes.
        Params:
        parameterTypes – the parameter array
        Returns:
        the Constructor object of the public constructor that matches the specified parameterTypes
         */
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);

        Constructor<?> constructor1 = cls.getConstructor(String.class); //cls is generate in the loading phase
        System.out.println(constructor1);

        //create cat instance by Constructor instance
        Object o2 = constructor.newInstance();
        System.out.println(o2.getClass());

        Object o3 = constructor1.newInstance("M1");
        System.out.println(o3.getClass());
    }
}
