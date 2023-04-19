package com.tekgs.nextgen.luckyPet.view.checkout;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.view.purchaseConfirmation.PurchaseConfirmationView;
import org.softwareonpurpose.gauntlet.Environment;

public class CheckoutView extends UiView implements CheckoutViewCalibratable {
    private static final String DESCRIPTION = "'Checkout' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "checkout";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String VIEW_URI = String.format("%s/checkout", DOMAIN_URL);

    public CheckoutView() {
        super(VIEW_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CheckoutView directNav() {
        new CheckoutView().load();
        return UiView.expect(CheckoutView.class);
    }

    public static CheckoutView directNav(Integer amountOwed) {
        new CheckoutView().load(String.format("?total=%d", amountOwed));
        return UiView.expect(CheckoutView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    public PurchaseConfirmationView submit(@SuppressWarnings("unused") Payment paymentData) {
        getSubmitElement().click();
        return UiView.expect(PurchaseConfirmationView.class);
    }

    private UiElement getSubmitElement() {
        String description = "'Submit' button";
        String locatorValue = "submit";
        return getViewElementById(description, locatorValue);
    }

    @Override
    public String getTotalOwed() {
        return getTotalOwedElement().getText();
    }

    private UiElement getTotalOwedElement() {
        String description = "Total Owed";
        String locatorValue = "total-owed";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getViewElementById(String description, String locatorValue) {
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }
}
