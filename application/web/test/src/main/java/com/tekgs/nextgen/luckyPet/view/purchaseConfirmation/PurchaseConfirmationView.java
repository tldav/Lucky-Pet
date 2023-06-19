package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;

public class PurchaseConfirmationView extends LuckyPetView implements PurchaseConfirmationViewCalibratable {
    private static final String RELATIVE_URI = "purchase-confirmation";
    private static final String DESCRIPTION = "'Purchase Confirmation' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "purchase-confirmation";
    
    public PurchaseConfirmationView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    private UiElement getConfirmationMessageElement() {
        return UiElement.getInstance("'Confirmation' message", LOCATOR_TYPE, "confirmation-message", this.getElement());
    }
    
    @Override
    public String getConfirmationMessage() {
        return this.getConfirmationMessageElement().getText();
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
}
