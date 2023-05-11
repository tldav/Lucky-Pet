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
        if (paymentData == null) {
            return "";
        }
        boolean isCurrencyValid = paymentData.getCurrency() == null || "usd".equals(paymentData.getCurrency());
        return isCurrencyValid ? "" : "Invalid Currency";
    }
    
    @Override
    public String getSourceErrorMessage() {
        if (paymentData == null) {
            return "";
        }
        boolean isSourceValid = paymentData.getSource() == null || "tok_amex".equals(paymentData.getSource());
        return isSourceValid ? "" : "Invalid Source";
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