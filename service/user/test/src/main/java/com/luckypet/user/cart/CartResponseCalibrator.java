package com.luckypet.user.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartResponseCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Cart' response" ;

    protected CartResponseCalibrator(CartResponseExpected expected, CartResponse actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static CartResponseCalibrator getInstance(CartResponseExpected expected, CartResponse actual) {
        return new CartResponseCalibrator(expected,actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
