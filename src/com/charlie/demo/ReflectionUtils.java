package com.charlie.demo;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * demonstrate get class structure info through reflection
 *
 * @author AC
 * @version 1.0
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //API group1
    @Test
    public void api_01() throws Exception {
        Class<?> cls = Class.forName("com.charlie.demo.TestAPI");

        String name = cls.getName();
        System.out.println(name);

        String simpleName = cls.getSimpleName();
        System.out.println(simpleName);

        //getFields(): get all public attributes
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println("sub and super all public attributes: " + field.getName());
        }

        //getDeclaredFields: get all attributes of this class
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("this class all attributes: " + declaredField.getName());
        }

        //getMethods: get all public method
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println("sub and super class all public methods: " + method.getName());
        }

        //getConstructors: get all this class public constructors
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("this all public constructors: " + constructor.getName());
        }

        //getDeclaredConstructors: get all this class constructor
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("this class all constructors: " + declaredConstructor.getName());
        }

        Package aPackage = cls.getPackage();
        System.out.println(aPackage);

        Class<?> superclass = cls.getSuperclass();
        Constructor<?> declaredConstructor = superclass.getDeclaredConstructor();
        System.out.println("super class constructor: " + declaredConstructor.getName());

        //getInterfaces: get interface
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("implementation interface: " + anInterface.getName());
        }

        //getAnnotations: return Annotations
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotations: " + annotation);
        }
    }

    @Test
    public void api_02() throws Exception {
        Class<?> cls = Class.forName("com.charlie.demo.TestAPI");

        /*
        0 default; 1 public; 2 private; 4 protected; 8 static; 16 final
        public(1) + static(8) = 9
         */
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("this class all attribute: " + declaredField.getName()
                    + " modifier = " + declaredField.getModifiers()
                    + " attribute type = " + declaredField.getType());
        }
    }

    @Test
    public void api_03() throws Exception {
        Class<?> cls = Class.forName("com.charlie.demo.TestAPI");

        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("this class method = " + declaredMethod.getName()
                    + " visit modifier = " + declaredMethod.getModifiers()
                    + " return type = " + declaredMethod.getReturnType());

            //print parameters array situation
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameters types = " + parameterType);
            }
        }
    }

    @Test
    public void api_4() throws Exception {
        Class<?> cls = Class.forName("com.charlie.demo.TestAPI");

        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("===================================================");
            System.out.println("this constructor = " + declaredConstructor.getName());

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("constructor parameters = " + parameterType);
            }
        }
    }
}

class BaseTestAPI {
    public String hobby;

    public BaseTestAPI() {
    }

    public BaseTestAPI(String hobby) {
        this.hobby = hobby;
    }

    public void hi() {
    }
}

interface AK {

}

interface AR {

}

@Deprecated
class TestAPI extends BaseTestAPI implements AK, AR {
    //attribute
    public String name;

    protected int age;

    String job;

    private double salary;

    public TestAPI() {
    }

    public TestAPI(String name) {
        this.name = name;
    }

    private TestAPI(String name, String hobby) {
        super(hobby);
        this.name = name;
    }

    //method
    public void m1(String name, int age, double salary) {
        System.out.println(name + age + salary);
    }

    protected void m2() {

    }

    void m3() {

    }

    private void m4() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
