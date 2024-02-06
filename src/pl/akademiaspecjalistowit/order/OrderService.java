package pl.akademiaspecjalistowit.order;

import pl.akademiaspecjalistowit.client.Client;
import pl.akademiaspecjalistowit.client.ClientConfiguration;
import pl.akademiaspecjalistowit.client.ClientService;
import pl.akademiaspecjalistowit.payment.PaymentService;
import pl.akademiaspecjalistowit.payment.PaymentType;

public class OrderService {

    private PaymentService paymentService;
    private ClientService clientService;

    public OrderService(PaymentService paymentService,
                        ClientService clientService) {
        this.paymentService = paymentService;
        this.clientService = clientService;
    }

    public void processOrder(Client client) {
//        1) Dla przedmiotów wybranych przez klienta pobierz aktualne ceny bazowe
//        2) Dla każdej pozycji nalicz rabat zgodny ze statusem klienta

//        3) Dokonaj płatności zgodnie z konfiguracją klienta
        System.out.println("Start processing for client " + client);
        ClientConfiguration paymentConfiguration = client.getPaymentConfiguration();
        PaymentType executedPaymentType = paymentService.pay(paymentConfiguration);

//        4) Powiadom klienta o realizacji płatności
        clientService.notifyAboutPayment(executedPaymentType, client);
        System.out.println("Processing for client " + client + " is finished");

    }
}
