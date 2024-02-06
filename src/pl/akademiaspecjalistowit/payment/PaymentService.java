package pl.akademiaspecjalistowit.payment;

import pl.akademiaspecjalistowit.client.ClientConfiguration;

public interface PaymentService {

    /**
     * this method executes the payment, and returns the typ of payment that was executed
     * @param paymentConfiguration
     * @return
     */
    PaymentType pay(ClientConfiguration paymentConfiguration);
}
