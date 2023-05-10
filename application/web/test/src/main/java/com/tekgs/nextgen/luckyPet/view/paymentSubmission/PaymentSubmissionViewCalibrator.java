package com.tekgs.nextgen.luckyPet.view.paymentSubmission;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentSubmissionViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Payment Submission' view";
    private final PaymentSubmissionViewExpected expected;
    private final PaymentSubmissionView actual;

    private PaymentSubmissionViewCalibrator(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static PaymentSubmissionViewCalibrator getInstance(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        return new PaymentSubmissionViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Currency' error message", expected.getCurrencyErrorMessage(), actual.getCurrencyErrorMessage());
        verify("'Source' error message", expected.getSourceErrorMessage(), actual.getSourceErrorMessage());
        verify("Total Owed", expected.getTotalOwed(), actual.getTotalOwed());
        verify("'Submit' Button is displayed", expected.isSubmitButtonDisplayed(), actual.isSubmitButtonDisplayed());
    }
}
