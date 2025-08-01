package payment.gateway.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import payment.gateway.DAO.PaymentDAO;
import payment.gateway.entity.PaymentRecord;
import payment.gateway.service.PaymentGateway;
import payment.gateway.storehouse.PaymentStorage;

@Component
@ComponentScan(basePackages = "payment.gateway.service")
public class PaymentProvider {

    private PaymentGateway paymentGateway;

    @Autowired
    private PaymentDAO paymentDAO;

    // Setter injection
    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(String customerName, double amount) {
        if (paymentGateway == null) {
            System.out.println("No payment gateway selected.");
            return;
        }

        // Step 1: Make the payment
        paymentGateway.payment(amount);

        // Step 2: Calculate cashback/offer
        double cashback = paymentGateway.festivalOffer(amount);
        double finalAmount = amount - cashback;

        System.out.println("Cashback Applied: ₹" + cashback);
        System.out.println("Final Payable Amount: ₹" + finalAmount);

        // Step 3: Store using Spring-enabled lambda and DAO
        PaymentStorage storage = (name, amt) -> {
            PaymentRecord record = PaymentRecord.builder()
                    .customerName(name)
                    .amount(amt)
                    .build();
            paymentDAO.savePayment(record);
        };

        storage.savePayment(customerName, finalAmount);
    }
}