package com.luckypet.user.data.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart'";
    
    private CartCalibrator(CartExpected expected, Cart actual) {
        super(DESCRIPTION, expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
    
    }
}
