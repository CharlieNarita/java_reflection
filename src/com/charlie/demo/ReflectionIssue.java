package com.charlie.demo;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author AC
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ReflectionIssue {
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
    }
}
