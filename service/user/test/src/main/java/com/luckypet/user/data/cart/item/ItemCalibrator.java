package com.luckypet.user.data.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ItemCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item'";
    private final ItemCalibratable expected;
    private final ItemCalibratable actual;

    private ItemCalibrator(ItemCalibratable expected, ItemCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ItemCalibrator getInstance(ItemCalibratable expected, ItemCalibratable actual){
        return new ItemCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Item' Quantity", this.expected.getQuantity(), this.actual.getQuantity());
    }
}
