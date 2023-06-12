package com.luckypet.user.data.product;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' data";
    private final ProductExpected expected;
    private final Product actual;
    
    private ProductCalibrator(ProductExpected expected, Product actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ProductCalibrator getInstance(ProductExpected expected, Product actual){
        return new ProductCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
        verify("'Product' id", this.expected.getId(), this.actual.getId());
        verify("'Product' description", this.expected.getDescription(), this.actual.getDescription());
        verify("'Product' price", this.expected.getPrice(), this.actual.getPrice());
        verify("'Product' stock", this.expected.getStock(), this.actual.getStock());
    }
}
