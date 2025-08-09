package com.example.config;

import com.example.entity.Student;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import javax.imageio.spi.ServiceRegistry;
import java.util.Properties;

public class OracleConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();

                // Hibernate Properties equivalent to hibernate.cfg.xml's properties
                Properties properties = new Properties();
                properties.put(Environment.JAKARTA_JDBC_DRIVER, "oracle.jdbc.OracleDriver");
                properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:oracle:thin:@localhost:1521:xe");
                properties.put(Environment.JAKARTA_JDBC_USER, "system");
                properties.put(Environment.JAKARTA_JDBC_PASSWORD, "989144");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.FORMAT_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Student.class); // Add your entity classes here

                sessionFactory = configuration.buildSessionFactory();
            }

            catch (HibernateException h){
                System.out.println("Hibernate Exception: " + h);
            }

            catch(Exception e){
                System.out.println("Initial SessionFactory creation failed or general failure." + e);
            }
        }
        return sessionFactory;
    }
}
