package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.Item;
import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.List;

public class CartExpected implements CartCalibratable {
    private CartCalibratable cart;
    private List<ItemCalibratable> itemListExpected;
    
    public CartExpected(CartCalibratable cart) {
        if (cart != null) {
            this.cart = cart;
            this.itemListExpected.addAll(cart.getItemList());
        }
    }
    
    public static CartExpected getInstance(CartCalibratable cart) {
        return new CartExpected(cart);
    }
    
    @Override
    public String getId() {
        return cart.getId();
    }
    
    @Override
    public List<ItemCalibratable> getItemList() {
        return null;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
