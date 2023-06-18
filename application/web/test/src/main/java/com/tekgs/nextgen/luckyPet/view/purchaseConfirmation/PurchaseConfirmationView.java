package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.gauntlet.Environment;

public class PurchaseConfirmationView extends UiView implements PurchaseConfirmationViewCalibratable {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URI = "purchase-confirmation";
    private static final String VIEW_URI = String.format("%s/%s", DOMAIN_URL, RELATIVE_URI);
    private static final String DESCRIPTION = "'Purchase Confirmation' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "purchase-confirmation";
    
    public PurchaseConfirmationView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    private UiElement getConfirmationMessageElement() {
        return UiElement.getInstance("'Confirmation' message", LOCATOR_TYPE, "confirmation-message", this.getElement());
    }
    
    @Override
    public String getConfirmationMessage() {
        return this.getConfirmationMessageElement().getText();
    }
    
    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
