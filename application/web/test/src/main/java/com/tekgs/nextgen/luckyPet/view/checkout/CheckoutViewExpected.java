package com.tekgs.nextgen.luckyPet.view.checkout;

import com.tekgs.nextgen.luckyPet.data.financial.Cents;
import com.tekgs.nextgen.luckyPet.data.payment.Payment;

public class CheckoutViewExpected implements CheckoutViewCalibratable {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Payment paymentData;
    
    public CheckoutViewExpected(Payment paymentData) {
        this.paymentData = paymentData;
    }
    
    public static CheckoutViewExpected getInstance() {
        return new CheckoutViewExpected(null);
    }
    
    public static CheckoutViewExpected getInstance(Payment paymentData) {
        return new CheckoutViewExpected(paymentData);
    }
    
    @Override
    public String getCurrencyErrorMessage() {
        // If payment data is null then the form is not being filled out or being submitted by the test.
        return this.paymentData == null || isCurrencyValid() ? "" : "Invalid Currency";
    }

    private boolean isCurrencyValid() {
        return this.paymentData.getCurrency() == null || "usd".equals(this.paymentData.getCurrency());
    }

    @Override
    public String getSourceErrorMessage() {
        // If payment data is null then the form is not being filled out or being submitted by the test.
        return this.paymentData == null || isSourceValid()  ? "" : "Invalid Source" ;
    }

    private boolean isSourceValid() {
        return this.paymentData.getSource() == null || "tok_amex".equals(this.paymentData.getSource());
    }

    @Override
    public String getTotalOwed() {
        int amount = this.paymentData == null ? 0 : this.paymentData.getAmount();
        Cents totalOwed = Cents.getInstance(amount);
        return totalOwed.inUsdFormat();
    }
    
    @Override
    public boolean isSubmitButtonDisplayed() {
        return true;
    }
}
