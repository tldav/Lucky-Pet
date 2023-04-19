package com.stripe.api.charges;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LuckyPetChargeResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Charges' response";
    private final LuckyPetCharge actual;
    private final LuckyPetChargeExpected expected;

    private LuckyPetChargeResponseCalibrator(LuckyPetChargeExpected expected, LuckyPetCharge actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static LuckyPetChargeResponseCalibrator getInstance(LuckyPetChargeExpected expected, LuckyPetCharge actual) {
        return new LuckyPetChargeResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is payment successful", expected.isPaymentSuccessful(), actual.isPaymentSuccessful());
    }
}
