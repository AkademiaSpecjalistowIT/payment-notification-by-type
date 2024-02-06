package pl.akademiaspecjalistowit.client;

import pl.akademiaspecjalistowit.payment.PaymentType;

public class Client {

    private String clientName;
    private ClientConfiguration clientConfiguration;

    public Client(String clientName)  {
        this.clientName = clientName;
        this.clientConfiguration = new ClientConfiguration();
    }

    public void addSupportedPaymentType(PaymentType paymentType){
        clientConfiguration.addPaymentType(paymentType);
    }

    public ClientConfiguration getPaymentConfiguration() {
        return clientConfiguration;
    }

    @Override
    public String toString() {
        return "Client{" +
            "clientName='" + clientName + '\'' +
            '}';
    }
}
