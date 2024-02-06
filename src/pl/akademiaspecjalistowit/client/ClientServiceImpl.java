package pl.akademiaspecjalistowit.client;

import java.util.List;
import pl.akademiaspecjalistowit.notification.NotificationService;
import pl.akademiaspecjalistowit.payment.PaymentType;

public class ClientServiceImpl implements ClientService {

    private final List<NotificationService> notificationServiceList;

    public ClientServiceImpl(
        List<NotificationService> notificationServiceList) {
        this.notificationServiceList = notificationServiceList;
    }

    @Override
    public void notifyAboutPayment(PaymentType executedPaymentType, Client client) {
        notificationServiceList.forEach(e -> e.sendNotification(client, executedPaymentType));
    }

}
