import org.hibernate.*;
import org.hibernate.query.Query;

import module java.base;

class Test_Select{
    static void main(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        IO.println("Got a sessionFactory: "+sf);

        try(Session ss = sf.openSession()){
            Query<Emp> query = ss.createQuery("from Emp", Emp.class);
            List<Emp> li = query.list();
            li.forEach(IO::println);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}