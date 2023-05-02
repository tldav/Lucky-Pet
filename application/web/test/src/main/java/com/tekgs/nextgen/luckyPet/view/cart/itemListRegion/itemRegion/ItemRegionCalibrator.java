package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ItemRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item' region";
    private final ItemRegionCalibratable expected;
    private final ItemRegionCalibratable actual;

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
        verify("'Product Price'", this.expected.getProductPrice(), this.actual.getProductPrice());
        verify("'Product Description'", this.expected.getProductDescription(), this.actual.getProductDescription());
        verify("'Line Item' total", this.expected.getLineItemTotal(), this.actual.getLineItemTotal());
        verify("'Line Item' quantity", this.expected.getLineItemQuantity(), this.actual.getLineItemQuantity());
    }
}
