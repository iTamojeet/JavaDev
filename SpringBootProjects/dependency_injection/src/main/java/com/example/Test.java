package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    static void main() {
        IO.println("Spring Framework");
//        ApplicationContext context = new ClassPathXmlApplicationContext();
//        IO.println(context);
        ApplicationContext context = new ClassPathXmlApplicationContext("bjp.xml");
        Student lala = (Student)context.getBean("b2");
        IO.println(lala);
    }
}
