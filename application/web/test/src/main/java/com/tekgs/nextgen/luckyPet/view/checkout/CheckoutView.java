package com.tekgs.nextgen.luckyPet.view.checkout;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.data.payment.Payment;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.purchaseConfirmation.PurchaseConfirmationView;

public class CheckoutView extends LuckyPetView implements CheckoutViewCalibratable {
    private static final String RELATIVE_URL = "checkout";
    private static final String DESCRIPTION = "'Checkout'' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "checkout-view";
    
    public CheckoutView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static CheckoutView directNav() {
        new CheckoutView().load();
        return LuckyPetView.expect(CheckoutView.class);
    }
    
    public static CheckoutView directNav(Integer amountOwed) {
        new CheckoutView().load(String.format("?total=%d", amountOwed));
        return LuckyPetView.expect(CheckoutView.class);
    }
    
    public CheckoutView enter(Payment paymentData) {
        //  Clicking the other input after setting a value is to trigger the on-blur function
        getCurrencyElement().set(paymentData.getCurrency());
        getSourceElement().click();
        getSourceElement().set(paymentData.getSource());
        getCurrencyElement().click();
        return LuckyPetView.expect(CheckoutView.class);
    }
    
    @SuppressWarnings("unused")
    public PurchaseConfirmationView submit(Payment paymentData) {
        this.getSubmitPaymentBtnElement().click();
        return LuckyPetView.expect(PurchaseConfirmationView.class);
    }
    
    private UiElement getCurrencyElement() {
        return UiElement.getInstance("'Currency' input", UiLocatorType.NAME, "currency-input", this.getElement());
    }
    
    private UiElement getSourceElement() {
        return UiElement.getInstance("'Source' input", UiLocatorType.NAME, "source-input", this.getElement());
    }
    
    private UiElement getSubmitPaymentBtnElement() {
        return UiElement.getInstance("'Submit Payment' button", UiLocatorType.ID, "submit-payment-btn", this.getElement());
    }
    
    private UiElement getTotalOwedElement() {
        return UiElement.getInstance("'Total Owed'", UiLocatorType.ID, "total-owed", this.getElement());
    }
    
    private UiElement getSourceErrorElement() {
        return UiElement.getInstance("'Source Error' message", UiLocatorType.ID, "source-error", this.getElement());
    }
    
    private UiElement getCurrencyErrorElement() {
        return UiElement.getInstance("'Currency Error' message", UiLocatorType.ID, "currency-error", this.getElement());
    }
    
    @Override
    public String getTotalOwed() {
        return this.getTotalOwedElement().getText();
    }
    
    @Override
    public String getCurrencyErrorMessage() {
        return this.getCurrencyErrorElement().getText();
    }
    
    @Override
    public String getSourceErrorMessage() {
        return this.getSourceErrorElement().getText();
    }
    
    @Override
    public boolean isSubmitButtonDisplayed() {
        return this.getSubmitPaymentBtnElement().isDisplayed();
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
}
