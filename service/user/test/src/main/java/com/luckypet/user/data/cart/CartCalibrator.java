package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.itemList.ItemListCalibrator;
import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart'";
    
    private CartCalibrator(CartExpected expected, Cart actual) {
        super(DESCRIPTION, expected, actual);
        this.addChildCalibrator(ItemListCalibrator.getInstance(expected.getItemList(), actual.getItemList()));
    }
    
    @Override
    protected void executeVerifications() {
    
    }
}
