package pl.akademiaspecjalistowit.notification;

import java.util.Set;
import pl.akademiaspecjalistowit.client.Client;
import pl.akademiaspecjalistowit.payment.PaymentConfiguration;
import pl.akademiaspecjalistowit.payment.PaymentType;

public class SmsNotificationService implements NotificationService {

    private final Set<PaymentType> supportedPaymentForSmsNotifications;

    public SmsNotificationService() {
        supportedPaymentForSmsNotifications =
            PaymentConfiguration.getPaymentTypeForNotificationType(NotificationType.SMS);
    }

    @Override
    public void sendNotification(Client client, PaymentType executedPaymentType) {
        if (!supportedPaymentForSmsNotifications.contains(executedPaymentType)) {
            return;
        }
        System.out.println("wysłano powiadomienie sms do klienta " + client);
    }
}
