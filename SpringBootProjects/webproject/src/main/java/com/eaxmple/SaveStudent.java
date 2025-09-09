package com.eaxmple;

import org.hibernate.Session;

public class SaveStudent {

    public Student saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            System.out.println("Student saved successfully");
        }
        return student;
    }
}
