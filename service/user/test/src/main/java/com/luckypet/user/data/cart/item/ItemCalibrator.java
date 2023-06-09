package com.luckypet.user.data.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ItemCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item'";

    private ItemCalibrator(ItemCalibratable expected, ItemCalibratable actual) {
        super(DESCRIPTION, expected, actual);
    }

    public static ItemCalibrator getInstance(ItemCalibratable expected, ItemCalibratable actual){
        return new ItemCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
