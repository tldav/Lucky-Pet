package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LowStockRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Low Stock' region";
    private final LowStockRegionCalibratable expected;
    private final LowStockRegionCalibratable actual;

    private LowStockRegionCalibrator(LowStockRegionCalibratable expected, LowStockRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static LowStockRegionCalibrator getInstance(LowStockRegionCalibratable expected, LowStockRegionCalibratable actual) {
        return new LowStockRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Product' stock", this.expected.getProductStock(), this.actual.getProductStock());
        verify("'Product' description", this.expected.getProductDescription(), this.actual.getProductDescription());
        verify("'Product' price", this.expected.getProductPrice(), this.actual.getProductPrice());
    }
}
