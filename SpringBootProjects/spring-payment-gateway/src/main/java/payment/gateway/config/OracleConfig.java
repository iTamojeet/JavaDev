package payment.gateway.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import payment.gateway.entity.PaymentRecord;

import java.util.Properties;

public class OracleConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.JAKARTA_JDBC_DRIVER, "oracle.jdbc.OracleDriver");
                properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:oracle:thin:@localhost:1521:xe");
                properties.put(Environment.JAKARTA_JDBC_USER, "scott");
                properties.put(Environment.JAKARTA_JDBC_PASSWORD, "tiger");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.FORMAT_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(PaymentRecord.class); // Link to entity

                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException h) {
                System.out.println("Hibernate Exception: " + h);
            } catch (Exception e) {
                System.out.println("Initial SessionFactory creation failed: " + e);
            }
        }
        return sessionFactory;
    }
}