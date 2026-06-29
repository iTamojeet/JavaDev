package com.example;

@FunctionalInterface
interface InnerDemo {
    void test();
    static void main(){

    }
    default void teacherName(){
        return;
    }
}

@FunctionalInterface
interface A {
    String test();
}

public class Demo {
    public static void main(String[] args) {
        InnerDemo i = new InnerDemo() {
            public void test(){
                IO.println("Anonymous Inner Class");
            }
        };

        A a = () -> "Jali lambda";
        a.test();
    }
}
