package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation.copy;

import com.tekgs.nextgen.luckyPet.view.copy.LuckyPetCopy;

public class PurchaseConfirmationViewCopy {
    private LuckyPetCopy copy;
    
    public static PurchaseConfirmationViewCopy getInstance() {
        return new PurchaseConfirmationViewCopy();
    }
    
    public String getConfirmation() {
        return this.getCopySource().getPurchaseConfirmationMessage();
    }
    
    private LuckyPetCopy getCopySource() {
        if (this.copy == null) {
            this.copy = LuckyPetCopy.getInstance();
        }
        return this.copy;
    }
}
