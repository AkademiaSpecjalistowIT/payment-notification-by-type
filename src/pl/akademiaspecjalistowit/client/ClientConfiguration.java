package pl.akademiaspecjalistowit.client;

import java.util.ArrayList;
import java.util.List;
import pl.akademiaspecjalistowit.payment.PaymentType;

public class ClientConfiguration {

    private List<PaymentType> supportedPaymentTypes;

    public ClientConfiguration() {
        supportedPaymentTypes = new ArrayList<>();
    }

    public void addPaymentType(PaymentType paymentType) {
        supportedPaymentTypes.add(paymentType);
    }

    public List<PaymentType> getSupportedPaymentTypes() {
        return List.copyOf(supportedPaymentTypes);
    }
}
