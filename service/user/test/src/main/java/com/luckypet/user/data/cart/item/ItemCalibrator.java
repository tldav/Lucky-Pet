package com.luckypet.user.data.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ItemCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item'";

    private ItemCalibrator(ItemExpected expected, Item actual) {
        super(DESCRIPTION, expected, actual);
    }

    public ItemCalibrator getInstance(ItemExpected expected, Item actual){
        return new ItemCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
