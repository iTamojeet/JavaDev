import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import payment.gateway.provider.PaymentProvider;
import payment.gateway.service.GooglePay;

public class PaymentGatewayTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PaymentProvider.class);

        PaymentProvider provider = context.getBean(PaymentProvider.class);

        // You can dynamically inject any gateway at runtime
        provider.setPaymentGateway(new GooglePay());

        provider.processPayment("Tamojeet Pal", 1000.0);
    }
}
