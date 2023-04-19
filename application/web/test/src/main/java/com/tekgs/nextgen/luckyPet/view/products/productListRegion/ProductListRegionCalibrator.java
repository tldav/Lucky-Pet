package com.tekgs.nextgen.luckyPet.view.products.productListRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion.ProductRegionCalibrator;

import java.util.List;

/* =================================================================****************************************
*                           Do not Delete this is for future refactoring
*
* =====================================================***************************************************
* */


public class ProductListRegionCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Product List' region";

    protected ProductListRegionCalibrator(ProductListRegionExpected expected, ProductListRegion actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        List<ProductRegionCalibratable> productsExpected = expected.getProductRegions();
        List<ProductRegionCalibratable> productsActual = actual.getProductRegions();
        addCalibrationsExpected(productsExpected, productsActual);
        addCalibrationsUnexpected(productsActual);
        UiRegion.suppressConstructionLogging(false);
    }

    private void addCalibrationsUnexpected(List<ProductRegionCalibratable> productsActual) {
        for (ProductRegionCalibratable productActual : productsActual) {
            addChildCalibrator(ProductRegionCalibrator.getInstance(null, productActual));
        }
    }

    private void addCalibrationsExpected(List<ProductRegionCalibratable> productsExpected, List<ProductRegionCalibratable> productsActual) {
        for (ProductRegionCalibratable productExpected: productsExpected) {
            ProductRegionCalibratable productFound = addCalibrationFound(productsActual, productExpected);
            if(productFound != null) {
                productsActual.remove(productFound);
            } else {
                addChildCalibrator(ProductRegionCalibrator.getInstance(productExpected, null));
            }
        }
    }

    private ProductRegionCalibratable addCalibrationFound(List<ProductRegionCalibratable> productsActual, ProductRegionCalibratable productExpected) {
        ProductRegionCalibratable productFound = null;
        for (ProductRegionCalibratable productActual : productsActual) {
            if(productActual.equivalent(productExpected)) {
                productFound = productActual;
                addChildCalibrator(ProductRegionCalibrator.getInstance(productExpected, productActual));
                break;
            }
        }
        return productFound;
    }

    @Override
    protected void executeVerifications() {
    }
}
