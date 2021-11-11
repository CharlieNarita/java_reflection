package com.charlie.classloadingdemo;

/**
 * @author AC
 * @version 1.0
 */
public class ClassLoad03 {
    public static void main(String[] args) throws Exception {
        /*
        when load class there is synchronized control

        protect Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
            //......
            }
        }
         */
        Class<?> c = Class.forName("C");

    }
}

class C {
    static {
        System.out.println("C static code block");
        num = 500;
    }

    static int num = 800;

    static final int id = 999;

    public C() {
        System.out.println("C constructor running");
    }
}
