package com.tekgs.nextgen.luckyPet.view.checkout;

public interface CheckoutViewCalibratable {
    String getTotalOwed();
    
    String getCurrencyErrorMessage();
    
    String getSourceErrorMessage();
    
    boolean isSubmitButtonDisplayed();
}
