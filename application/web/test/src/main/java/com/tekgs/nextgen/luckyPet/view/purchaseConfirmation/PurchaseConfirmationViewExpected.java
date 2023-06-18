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
    
    private PurchaseConfirmationViewCopy getCopy() {
        if (this.copy == null) {
            this.copy = PurchaseConfirmationViewCopy.getInstance();
        }
        return this.copy;
    }
    
    @Override
    public String getConfirmationMessage() {
        return this.getCopy().getConfirmation();
    }
}
