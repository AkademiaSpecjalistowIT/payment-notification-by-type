package pl.akademiaspecjalistowit.payment.type;

public class CardPayment implements Payment {


    @Override
    public void pay() {
        System.out.println("płatność kartą");
    }
}
