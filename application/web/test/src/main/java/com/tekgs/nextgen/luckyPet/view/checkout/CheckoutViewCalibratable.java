package com.tekgs.nextgen.luckyPet.view.checkout;

public interface CheckoutViewCalibratable {
    String getCurrencyErrorMessage();

    String getSourceErrorMessage();
    String getTotalOwed();

    boolean isSubmitButtonDisplayed();
}
