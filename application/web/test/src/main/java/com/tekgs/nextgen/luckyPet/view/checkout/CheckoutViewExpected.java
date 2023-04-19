package com.tekgs.nextgen.luckyPet.view.checkout;

import com.tekgs.nextgen.luckyPet.data.financial.Cents;
import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.data.payment.PaymentDefinition;

public class CheckoutViewExpected implements CheckoutViewCalibratable {
    private final Payment payment;

    public CheckoutViewExpected(Payment payment) {
        this.payment = payment;
    }

    public static CheckoutViewExpected getInstance() {
        return new CheckoutViewExpected(PaymentDefinition.getInstance().toPayment());
    }

    public static CheckoutViewExpected getInstance(Payment payment) {
        return new CheckoutViewExpected(payment);
    }

    @Override
    public String getTotalOwed() {
        Cents totalOwed = Cents.getInstance(this.payment.getAmount());
        return totalOwed.inUsdFormat();
    }
}
