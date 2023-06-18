package com.tekgs.nextgen.luckyPet.view.checkout;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CheckoutViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Payment Submission' view";
    private final CheckoutViewExpected expected;
    private final CheckoutView actual;
    
    private CheckoutViewCalibrator(CheckoutViewExpected expected, CheckoutView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }
    
    public static CheckoutViewCalibrator getInstance(CheckoutViewExpected expected, CheckoutView actual) {
        return new CheckoutViewCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
        verify("'Currency' error message", this.expected.getCurrencyErrorMessage(), this.actual.getCurrencyErrorMessage());
        verify("'Source' error message", this.expected.getSourceErrorMessage(), this.actual.getSourceErrorMessage());
        verify("Total Owed", this.expected.getTotalOwed(), this.actual.getTotalOwed());
        verify("'Submit' Button is displayed", this.expected.isSubmitButtonDisplayed(), this.actual.isSubmitButtonDisplayed());
    }
}
