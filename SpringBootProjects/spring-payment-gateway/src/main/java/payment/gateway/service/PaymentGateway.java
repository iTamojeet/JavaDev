package payment.gateway.service;

public interface PaymentGateway {
    void payment(double amount);
    double festivalOffer(double amount);
}