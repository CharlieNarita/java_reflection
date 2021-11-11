package com.charlie.classloadingdemo;

/**
 * @author AC
 * @version 1.0
 */
public class ClassLoad02 {
    public static void main(String[] args) {
        //1.load B, generate a B class object
        //2.link B, num = 0;
        //3.init B, generate clinit() method
        /*
            clinit() {
                System.out.println("B static code block running");
                num = 300;
                num = 100;
            }

            consolidation initialization result:
            num = 100;


         */
        //4.call constructor if new instance

        //create instance will load class
        new B();

        //invoke static member will load class too
        System.out.println(B.num);
    }
}

class B {

    static {
        System.out.println("B static code block");
        num = 300;
    }

    static int num = 100;

    public B() {
        System.out.println("B constructor running");
    }
}
