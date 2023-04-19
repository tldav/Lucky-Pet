package com.tekgs.nextgen.luckyPet.view.checkout;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CheckoutViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Checkout' view";
    private final CheckoutView actual;
    private final CheckoutViewExpected expected;

    private CheckoutViewCalibrator(CheckoutViewExpected expected, CheckoutView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static CheckoutViewCalibrator getInstance(CheckoutViewExpected expected, CheckoutView actual) {
        return new CheckoutViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Total Owed", expected.getTotalOwed(), actual.getTotalOwed());
    }
}
