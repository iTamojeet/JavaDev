import org.hibernate.*;

class Test{
    static void main(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // IO.println(sf);

        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        Student tamo = new Student("Tamojeet", "Kolkata", 999);
        ss.persist(tamo);
        tr.commit();
        ss.close();
        IO.println("-------------------SAVED-------------------");
    }
}