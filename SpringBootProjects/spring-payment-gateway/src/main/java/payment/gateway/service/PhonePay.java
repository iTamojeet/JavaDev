package payment.gateway.service;

import org.springframework.stereotype.Component;

@Component("phonepay")
public class PhonePay implements PaymentGateway {
    @Override
    public void payment(double amount) {
        System.out.println("PhonePay processed: " + amount);
    }

    @Override
    public double festivalOffer(double amount) {
        return amount * 0.07;
    }
}