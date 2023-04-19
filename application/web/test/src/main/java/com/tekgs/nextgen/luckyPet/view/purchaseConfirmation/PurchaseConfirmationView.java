package com.tekgs.nextgen.luckyPet.view.purchaseConfirmation;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import org.softwareonpurpose.gauntlet.Environment;

public class PurchaseConfirmationView extends UiView implements PurchaseConfirmationViewCalibratable {
    private static final String LOCATOR_VALUE = "purchase-confirmation";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Purchase Confirmation' view";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String VIEW_URI = String.format("%s/purchase-confirmation", DOMAIN_URL);

    public PurchaseConfirmationView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    @Override
    public String getConfirmationMessage() {
        return getConfirmationMessageElement().getText();
    }

    private UiElement getConfirmationMessageElement() {
        String description = "Confirmation Message";
        String locatorValue = "confirmation-message";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }
}
