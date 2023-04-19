package com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' region";
    private final ProductRegionCalibratable actual;
    private final ProductRegionCalibratable expected;

    private ProductRegionCalibrator(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductRegionCalibrator getInstance(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        return new ProductRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Product' out of stock message", this.expected.getOutOfStockMessage(), this.actual.getOutOfStockMessage());
        verify("'Product' description", this.expected.getProductDescription(), this.actual.getProductDescription());
        verify("'Product' price", this.expected.getPrice(), this.actual.getPrice());
        verify("'Add to cart' button enabled", this.expected.isAddToCartEnabled(), this.actual.isAddToCartEnabled());
    }
}
