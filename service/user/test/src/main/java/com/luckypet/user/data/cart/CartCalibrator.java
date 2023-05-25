package com.luckypet.user.data.cart;

import com.luckypet.ListCalibrator;
import com.luckypet.user.data.cart.item.ItemCalibratable;
import com.luckypet.user.data.cart.item.ItemCalibrator;

import java.util.List;

public class CartCalibrator extends ListCalibrator<ItemCalibrator, ItemCalibratable> {
    private static final String DESCRIPTION = "'Cart' data";

    private CartCalibrator(CartCalibratable expected, CartCalibratable actual) {
        super(DESCRIPTION, expected, actual, ItemCalibrator.class, ItemCalibratable.class);
        List<ItemCalibratable> itemListExpected = expected.getItemList();
        List<ItemCalibratable> itemListActual = actual.getItemList();
        this.addCalibrationsExpected(itemListExpected, itemListActual);
        this.addCalibrationsUnexpected(itemListActual);
    }

    public CartCalibrator getInstance(CartCalibratable expected, CartCalibratable actual){
        return new CartCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
    
    }
}
