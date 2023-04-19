package com.tekgs.nextgen.luckyPet.data.payment;

public class PaymentProvider {
    public static PaymentProvider getInstance() {
        return new PaymentProvider();
    }

    public Payment get() {
        return Payment.getInstance();
    }

    public Payment get(PaymentDefinition paymentDefinition) {
        return paymentDefinition.toPayment();
    }
}
