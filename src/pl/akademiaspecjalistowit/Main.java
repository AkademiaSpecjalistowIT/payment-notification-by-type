package pl.akademiaspecjalistowit;

import java.util.List;
import pl.akademiaspecjalistowit.client.Client;
import pl.akademiaspecjalistowit.client.ClientService;
import pl.akademiaspecjalistowit.client.ClientServiceImpl;
import pl.akademiaspecjalistowit.notification.EmailNotificationService;
import pl.akademiaspecjalistowit.notification.NotificationService;
import pl.akademiaspecjalistowit.notification.SmsNotificationService;
import pl.akademiaspecjalistowit.order.OrderService;
import pl.akademiaspecjalistowit.payment.PaymentConfiguration;
import pl.akademiaspecjalistowit.payment.PaymentService;
import pl.akademiaspecjalistowit.payment.PaymentServiceImpl;
import pl.akademiaspecjalistowit.payment.PaymentType;

public class Main {

    public static void main(String[] args) {

        //setup env
        PaymentConfiguration paymentConfiguration = new PaymentConfiguration();
        PaymentService paymentService = new PaymentServiceImpl(paymentConfiguration);

        List<NotificationService> notificationServices =
            List.of(new EmailNotificationService(), new SmsNotificationService());

        ClientService clientService = new ClientServiceImpl(notificationServices);
        OrderService orderService = new OrderService(paymentService, clientService);
        // end setup env


        Client adam = new Client("Adam");
        adam.addSupportedPaymentType(PaymentType.BLIK);

        Client olek = new Client("Olek");
        olek.addSupportedPaymentType(PaymentType.CARD);

        Client romek = new Client("Romek");
        romek.addSupportedPaymentType(PaymentType.TRANSFER);

        orderService.processOrder(adam);
        System.out.println("\n");
        orderService.processOrder(olek);
        System.out.println("\n");
        orderService.processOrder(romek);
    }
}
