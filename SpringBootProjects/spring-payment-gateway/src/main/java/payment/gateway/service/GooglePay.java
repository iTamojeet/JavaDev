package payment.gateway.service;

import org.springframework.stereotype.Component;

@Component("googlepay")
public class GooglePay implements PaymentGateway {
    @Override
    public void payment(double amount) {
        System.out.println("GooglePay processed: " + amount);
    }

    @Override
    public double festivalOffer(double amount) {
        return amount * 0.08;
    }
}