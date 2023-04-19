package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ItemRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item' region";
    private final ItemRegionCalibratable actual;
    private final ItemRegionCalibratable expected;

    private ItemRegionCalibrator(ItemRegionCalibratable expected, ItemRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ItemRegionCalibrator getInstance(ItemRegionCalibratable expected, ItemRegionCalibratable actual) {
        return new ItemRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Cost", expected.getPrice(), actual.getPrice());
        verify("Item Description", expected.getItemDescription(), actual.getItemDescription());
    }
}
