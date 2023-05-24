package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.itemList.ItemListCalibratable;
import com.luckypet.user.data.cart.itemList.ItemListExpected;

public class CartExpected implements CartCalibratable {
    private CartCalibratable cart;
    private ItemListExpected itemListExpected;
    
    public CartExpected(CartCalibratable cart) {
        if (cart != null) {
            this.cart = cart;
            this.itemListExpected.getItems().addAll(cart.getItemList().getItems());
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
    public ItemListCalibratable getItemList() {
        return null;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
