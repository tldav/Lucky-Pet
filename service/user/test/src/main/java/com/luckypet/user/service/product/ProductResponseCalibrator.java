package com.luckypet.user.service.product;

import com.luckypet.ListCalibrator;
import com.luckypet.user.data.product.ProductCalibratable;
import com.luckypet.user.data.product.ProductCalibrator;

import java.util.List;

public class ProductResponseCalibrator extends ListCalibrator<ProductCalibrator, ProductCalibratable> {
    private static final String DESCRIPTION = "'Product' Response";
    private final ProductResponseCalibratable expected;
    private final ProductResponseCalibratable actual;
    
    protected ProductResponseCalibrator(ProductResponseCalibratable expected, ProductResponseCalibratable actual) {
        super(DESCRIPTION, expected, actual, ProductCalibrator.class, ProductCalibratable.class);
        this.expected = expected;
        this.actual = actual;
        List<ProductCalibratable> productListExpected = expected.getProducts();
        List<ProductCalibratable> productListActual = actual.getProducts();
        this.addCalibrationsExpected(productListExpected, productListActual);
        this.addCalibrationsUnexpected(productListActual);
    }
    
    public static ProductResponseCalibrator getInstance(ProductResponseCalibratable expected, ProductResponseCalibratable actual) {
        return new ProductResponseCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
        verify("Is successful response", this.expected.isSuccessful(), this.actual.isSuccessful());
    }
}
