package com.luckypet.user.data.cart;

import com.luckypet.ListCalibrator;
import com.luckypet.user.data.cart.item.ItemCalibratable;
import com.luckypet.user.data.cart.item.ItemCalibrator;

import java.util.List;

public class CartCalibrator extends ListCalibrator<ItemCalibrator, ItemCalibratable> {
    private static final String DESCRIPTION = "'Cart' data";
    private final CartCalibratable expected;
    private final CartCalibratable actual;
    
    private CartCalibrator(CartCalibratable expected, CartCalibratable actual) {
        super(DESCRIPTION, expected, actual, ItemCalibrator.class, ItemCalibratable.class);
        this.expected = expected;
        this.actual = actual;
        List<ItemCalibratable> itemListExpected = expected.getItemList();
        List<ItemCalibratable> itemListActual = actual.getItemList();
        this.addCalibrationsExpected(itemListExpected, itemListActual);
        this.addCalibrationsUnexpected(itemListActual);
    }

    public static CartCalibrator getInstance(CartCalibratable expected, CartCalibratable actual){
        return new CartCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("'Card' id", this.expected.getId(), this.actual.getId());
    }
}
