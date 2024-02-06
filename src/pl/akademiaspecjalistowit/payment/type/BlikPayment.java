package pl.akademiaspecjalistowit.payment.type;

public class BlikPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("płatność BLIK");
    }
}
