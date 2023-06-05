package com.luckypet.user.service.product;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' Response";
    private final ProductResponseExpected expected;
    private final ProductResponse actual;

    protected ProductResponseCalibrator(ProductResponseExpected expected, ProductResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductResponseCalibrator getInstance(ProductResponseExpected expected, ProductResponse actual) {
        return new ProductResponseCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is successful response", this.expected.isSuccessful(), this.actual.isSuccessful());
    }
}
