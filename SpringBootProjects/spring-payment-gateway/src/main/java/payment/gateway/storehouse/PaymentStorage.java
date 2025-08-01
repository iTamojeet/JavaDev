package payment.gateway.storehouse;

@FunctionalInterface
public interface PaymentStorage {
    void savePayment(String customerName, double amount);
}