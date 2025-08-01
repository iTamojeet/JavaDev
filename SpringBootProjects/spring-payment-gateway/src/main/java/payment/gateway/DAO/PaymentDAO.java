package payment.gateway.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import payment.gateway.config.OracleConfig;
import payment.gateway.entity.PaymentRecord;

public class PaymentDAO {

    public void savePayment(PaymentRecord record) {
        Transaction tx = null;
        try (Session session = OracleConfig.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(record);
            tx.commit();
            System.out.println("Payment saved successfully: " + record);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Failed to save payment: " + e.getMessage());
        }
    }
}
