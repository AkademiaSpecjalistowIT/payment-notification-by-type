package pl.akademiaspecjalistowit.notification;

import java.util.Set;
import pl.akademiaspecjalistowit.client.Client;
import pl.akademiaspecjalistowit.payment.PaymentConfiguration;
import pl.akademiaspecjalistowit.payment.PaymentType;

public class EmailNotificationService implements NotificationService {

    private final Set<PaymentType> supportedPaymentForEmailNotifications;

    public EmailNotificationService() {
        this.supportedPaymentForEmailNotifications =
            PaymentConfiguration.getPaymentTypeForNotificationType(NotificationType.EMAIL);
    }

    @Override
    public void sendNotification(Client client, PaymentType executedPaymentType) {
        if (!supportedPaymentForEmailNotifications.contains(executedPaymentType)) {
            return;
        }

        System.out.println("wysłano powiadomienie email do klienta " + client);
    }
}
