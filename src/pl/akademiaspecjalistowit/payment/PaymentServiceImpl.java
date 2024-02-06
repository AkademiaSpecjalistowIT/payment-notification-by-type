package pl.akademiaspecjalistowit.payment;

import pl.akademiaspecjalistowit.client.ClientConfiguration;
import pl.akademiaspecjalistowit.payment.type.Payment;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentConfiguration paymentConfiguration;

    public PaymentServiceImpl(PaymentConfiguration paymentConfiguration) {
        this.paymentConfiguration = paymentConfiguration;
    }

    @Override
    public PaymentType pay(ClientConfiguration clientConfiguration) {
        PaymentType paymentType = selectClientPaymentType(clientConfiguration);
        Payment payment = paymentConfiguration.selectPaymentStrategy(paymentType);
        payment.pay();
        return paymentType;
    }

    private PaymentType selectClientPaymentType(ClientConfiguration paymentConfiguration) {
        if (paymentConfiguration.getSupportedPaymentTypes().isEmpty()) {
            throw new RuntimeException();
        }
        return paymentConfiguration.getSupportedPaymentTypes().get(0);
    }
}
