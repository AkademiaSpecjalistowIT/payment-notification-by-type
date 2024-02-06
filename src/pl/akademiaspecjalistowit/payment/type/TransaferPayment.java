package pl.akademiaspecjalistowit.payment.type;

public class TransaferPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Płatność przelewem");
    }
}
