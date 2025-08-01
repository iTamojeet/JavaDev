package payment.gateway.service;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PayPal implements PaymentGateway {
    @Override
    public void payment(double amount) {
        System.out.println("PayPal processed: " + amount);
    }

    @Override
    public double festivalOffer(double amount) {
        return amount * 0.01;
    }
}