package com.tekgs.nextgen.luckyPet.view.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegionCalibrator;

public class CartViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Shopping Cart' view";
    private final CartViewExpected expected;
    private final CartView actual;
    
    private CartViewCalibrator(CartViewExpected expected, CartView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(ItemListRegionCalibrator.getInstance(expected.inItemListRegion(), actual.inItemListRegion()));
        UiRegion.suppressConstructionLogging(false);
    }
    
    public static CartViewCalibrator getInstance(CartViewExpected expected, CartView actual) {
        return new CartViewCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
        // executeChildCalibrators()
        verify("Total", this.expected.getTotal(), this.actual.getTotal());
    }
}
