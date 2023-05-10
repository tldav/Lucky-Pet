package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

public interface PaymentSubmissionViewCalibratable {
    String getCurrencyErrorMessage();

    String getSourceErrorMessage();
    String getTotalOwed();

    boolean isSubmitButtonDisplayed();
}
