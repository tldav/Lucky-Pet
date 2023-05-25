package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final CartCalibratable cartExpected;
    private final List<ItemCalibratable> itemListExpected;
    
    public CartExpected(CartCalibratable cart) {
        this.cartExpected = cart;
        this.itemListExpected = new ArrayList<>();
        if (cart != null) {
            this.itemListExpected.addAll(cart.getItemList());
        }
    }
    
    public static CartExpected getInstance(CartCalibratable cart) {
        return new CartExpected(cart);
    }
    
    @Override
    public String getId() {
        return this.cartExpected.getId();
    }
    
    @Override
    public List<ItemCalibratable> getItemList() {
        return this.itemListExpected;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
