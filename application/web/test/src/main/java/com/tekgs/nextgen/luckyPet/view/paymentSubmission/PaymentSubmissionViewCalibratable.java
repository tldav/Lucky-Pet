package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

public interface PaymentSubmissionViewCalibratable {
    String getCurrencyError();

    String getSourceError();
    String getTotalOwed();

    boolean isSubmitButtonDisplayed();
}
