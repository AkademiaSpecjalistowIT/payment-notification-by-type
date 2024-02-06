package pl.akademiaspecjalistowit.payment;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import pl.akademiaspecjalistowit.notification.NotificationType;
import pl.akademiaspecjalistowit.payment.type.BlikPayment;
import pl.akademiaspecjalistowit.payment.type.CardPayment;
import pl.akademiaspecjalistowit.payment.type.Payment;
import pl.akademiaspecjalistowit.payment.type.TransaferPayment;

public class PaymentConfiguration {

    private static final Map<PaymentType, Set<NotificationType>> paymentTypeToNotificationMapper = Map.of(
        PaymentType.CARD, Set.of(NotificationType.SMS, NotificationType.EMAIL),
        PaymentType.TRANSFER, Set.of(NotificationType.EMAIL),
        PaymentType.BLIK, Set.of(NotificationType.SMS)
    );

    public Payment selectPaymentStrategy(PaymentType paymentType) {
        if (paymentType == PaymentType.BLIK) {
            return new BlikPayment();
        }
        if (paymentType == PaymentType.CARD) {
            return new CardPayment();
        }
        if (paymentType == PaymentType.TRANSFER) {
            return new TransaferPayment();
        }
        throw new UnsupportedOperationException("Nienany typ płatności");
    }

    public static Set<PaymentType> getPaymentTypeForNotificationType(NotificationType notificationType) {
        HashSet<PaymentType> paymentTypes = new HashSet<>();
        for(var notifications : paymentTypeToNotificationMapper.entrySet()){
            if(notifications.getValue().contains(notificationType)){
                paymentTypes.add(notifications.getKey());
            }
        }
        return paymentTypes;
    }

}
