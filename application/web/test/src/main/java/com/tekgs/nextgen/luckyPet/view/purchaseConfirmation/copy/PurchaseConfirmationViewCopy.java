package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation.copy;

import com.tekgs.nextgen.luckyPet.view.copy.LuckyPetCopy;

public class PurchaseConfirmationViewCopy {
    private LuckyPetCopy copy;

    public static PurchaseConfirmationViewCopy getInstance() {
        return new PurchaseConfirmationViewCopy();
    }

    public String getConfirmation() {
        return getCopySource().getPurchaseConfirmationMessage();
    }

    private LuckyPetCopy getCopySource() {
        if (copy == null) {
            copy = LuckyPetCopy.getInstance();
        }
        return copy;
    }
}
