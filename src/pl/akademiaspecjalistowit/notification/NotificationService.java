package pl.akademiaspecjalistowit.notification;

import pl.akademiaspecjalistowit.client.Client;
import pl.akademiaspecjalistowit.payment.PaymentType;

public interface NotificationService {

    void sendNotification(Client client, PaymentType executedPaymentType);
}
