package pl.akademiaspecjalistowit.client;

import pl.akademiaspecjalistowit.payment.PaymentType;

public interface ClientService {

    void notifyAboutPayment(PaymentType executedPaymentType, Client client);
}
