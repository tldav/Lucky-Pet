package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation;

import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.view.purchaseConfirmation.copy.PurchaseConfirmationViewCopy;

public class PurchaseConfirmationViewExpected implements PurchaseConfirmationViewCalibratable {
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final Payment payment;
    private PurchaseConfirmationViewCopy copy;

    public PurchaseConfirmationViewExpected(Payment payment) {
        this.payment = payment;
    }

    public static PurchaseConfirmationViewExpected getInstance(Payment payment) {
        return new PurchaseConfirmationViewExpected(payment);
    }

    @Override
    public String getConfirmationMessage() {
        return getCopy().getConfirmation();
    }

    private PurchaseConfirmationViewCopy getCopy() {
        if (copy == null) {
            copy = PurchaseConfirmationViewCopy.getInstance();
        }
        return copy;
    }
}
