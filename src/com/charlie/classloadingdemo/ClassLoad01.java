package com.charlie.classloadingdemo;

/**
 * @author AC
 * @version 1.0
 */
public class ClassLoad01 {
    public static void main(String[] args) {

    }
}

class A {
    //attribute == member variable == field
    /*
    1.n1 is instance attribute, it is not a static variable, JVM do not allocate RAM for it;
    2.n2 is static variable, default initialize value is 0 but not 20
    3.n3 is static final type, it is constant value, so allocate RAM for it and initialize value as 30

     */
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}
