import module java.base;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil{
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();

            // Hibernate Properties equivalent to hibernate.cfg.xml's properties
            Properties properties = new Properties();
            properties.put(Environment.JAKARTA_JDBC_DRIVER, "oracle.jdbc.OracleDriver");
            properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:oracle:thin:@localhost:1521:XE");
            properties.put(Environment.JAKARTA_JDBC_USER, "c##scott");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD, "tiger");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.FORMAT_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "update");

            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Emp.class);// Add your entity classes here

            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        }
        return sessionFactory;
    }
}