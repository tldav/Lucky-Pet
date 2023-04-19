package com.tekgs.nextgen.luckyPet.view.products;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class ProductsViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Products' view";
    private final ProductsViewExpected expected;
    private final ProductsView actual;
    
    private ProductsViewCalibrator(ProductsViewExpected expected, ProductsView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        UiRegion.suppressConstructionLogging(true);
        List<ProductRegionCalibratable> productsExpected = expected.inProductListRegion().getProductRegions();
        List<ProductRegionCalibratable> productsActual = new ArrayList<>(actual.inProductListRegion().getProductRegions());
        addCalibrationsExpected(productsExpected, productsActual);
        addCalibrationsUnexpected(productsActual);
        UiRegion.suppressConstructionLogging(false);
    }
    
    public static ProductsViewCalibrator getInstance(ProductsViewExpected expected, ProductsView actual) {
        return new ProductsViewCalibrator(expected, actual);
    }
    
    private void addCalibrationsExpected(List<ProductRegionCalibratable> productsExpected,
                                         List<ProductRegionCalibratable> productsActual) {
        for (ProductRegionCalibratable productExpected : productsExpected) {
            ProductRegionCalibratable productFound = addCalibrationFound(productsActual, productExpected);
            if (productFound != null) {
                productsActual.remove(productFound);
            } else {
                addChildCalibrator(ProductRegionCalibrator.getInstance(productExpected, null));
            }
        }
    }
    
    private ProductRegionCalibratable addCalibrationFound(List<ProductRegionCalibratable> productsActual,
                                                          ProductRegionCalibratable productExpected) {
        ProductRegionCalibratable productFound = null;
        for (ProductRegionCalibratable productActual : productsActual) {
            if (productActual.equivalent(productExpected)) {
                productFound = productActual;
                addChildCalibrator(ProductRegionCalibrator.getInstance(productExpected, productActual));
                break;
            }
        }
        return productFound;
    }
    
    private void addCalibrationsUnexpected(List<ProductRegionCalibratable> productsActual) {
        for (ProductRegionCalibratable productActual : productsActual) {
            addChildCalibrator(ProductRegionCalibrator.getInstance(null, productActual));
        }
    }
    
    @Override
    protected void executeVerifications() {
    
    }
}
