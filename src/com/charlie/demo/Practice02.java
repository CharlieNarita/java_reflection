package com.charlie.demo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 1.get File Class obj
 * 2.print all File constructors on console
 * 3.create File instance by newInstance method
 * 4.create "src\\reflection_test.txt" file
 *
 * @author AC
 * @version 1.0
 */
public class Practice02 {
    public static void main(String[] args) throws Exception {
        //1.get File Class obj
        Class<?> fileCls = Class.forName("java.io.File");

        //2.print all File constructors on console
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        String filePath = "src\\reflection_test.txt";

        //3.create File instance by newInstance method
        Constructor<?> declaredConstructor = fileCls.getDeclaredConstructor(String.class);
        Object file = declaredConstructor.newInstance(filePath);   //get File instance
        System.out.println(file.getClass());

        //4.create "src\\reflection_test.txt" file
        Method createNewFile = fileCls.getDeclaredMethod("createNewFile");
        Object isOK = createNewFile.invoke(file);
        if ((boolean) isOK) {
            System.out.println("file is created successful!");
        } else {
            System.out.println("file is not create");
        }
    }
}
