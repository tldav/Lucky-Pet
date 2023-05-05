package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.view.checkout.CheckoutView;
import com.tekgs.nextgen.luckyPet.view.purchaseConfirmation.PurchaseConfirmationView;

import javax.swing.*;

public class PaymentSubmissionView extends UiView implements PaymentSubmissionViewCalibratable {
    private static final String VIEW_URL = "http://localhost:3000/payment-submission";
    private static final String DESCRIPTION = "'Payment Submission' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "payment-submission";

    public PaymentSubmissionView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PaymentSubmissionView directNav() {
        new PaymentSubmissionView().load();
        return UiView.expect(PaymentSubmissionView.class);
    }

    public static PaymentSubmissionView directNav(Integer amountOwed) {
        new PaymentSubmissionView().load(String.format("?total=%d", amountOwed));
        return UiView.expect(PaymentSubmissionView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().isDisplayed();
    }

    public PaymentSubmissionView enter(Payment paymentData) {
        //  Clicking the other field after setting a value is to trigger the on-blur function
        getCurrencyElement().set(paymentData.getCurrency());
        getSourceElement().click();
        getSourceElement().set(paymentData.getSource());
        getCurrencyElement().click();
        return UiView.expect(PaymentSubmissionView.class);
    }

    private UiElement getCurrencyElement() {
        String description = "'Currency' field";
        String locatorValue = "currency";
        return UiElement.getInstance(description, UiLocatorType.NAME, locatorValue, this.getElement());
    }

    private UiElement getSourceElement() {
        String description = "'Source' field";
        String locatorValue = "source";
        return UiElement.getInstance(description, UiLocatorType.NAME, locatorValue, this.getElement());
    }

    @Override
    public String getCurrencyError() {
        return getCurrencyErrorElement().getText();
    }

    @Override
    public String getSourceError() {
        return getSourceErrorElement().getText();
    }

    @Override
    public String getTotalOwed() {
        return getTotalOwedElement().getText();
    }

    @Override
    public boolean isSubmitButtonDisplayed() {
        return getSubmitButtonElement().isDisplayed();
    }

    private UiElement getSubmitButtonElement() {
        String description = "'Submit' button";
        String locatorValue = "submit";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    private UiElement getTotalOwedElement() {
        String description = "Total Owed";
        String locatorValue = "total-owed";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    private UiElement getSourceErrorElement() {
        String description = "'Source' error message";
        String locatorValue = "source-error";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    private UiElement getCurrencyErrorElement() {
        String description = "'Currency' error message";
        String locatorValue = "currency-error";
        return UiElement.getInstance(description, UiLocatorType.ID, locatorValue, this.getElement());
    }

    public PurchaseConfirmationView submit(@SuppressWarnings("unused") Payment paymentData) {
        getSubmitButtonElement().click();
        return UiView.expect(PurchaseConfirmationView.class);
    }
}
