package com.example;

import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.example.config.OracleConfig;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = OracleConfig.getSessionFactory();
        System.out.println("Session Factory created: " + sessionFactory);

        Session session = sessionFactory.openSession();
        System.out.println("Session opened: " + session);

        Transaction tx = session.beginTransaction();
        System.out.println("Transaction started: " + tx);

        Student student = new Student();
        student.setName("Dinosaur");

        session.persist(student); // Insert qeury

        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
