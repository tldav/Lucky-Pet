package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.itemList.ItemList;
import com.luckypet.user.data.cart.itemList.ItemListCalibratable;

public class CartDefinition implements CartCalibratable {
    private String id;
    private ItemList itemList; // <- is good or needs to be calibratable?
    
    private CartDefinition(CartCalibratable cart) {
        if (cart != null) {
            this.itemList.getItems().addAll(cart.getItemList().getItems());
            this.id = cart.getId();
        }
    }
    
    public static CartCalibratable getInstance() {
        return new CartDefinition(null);
    }
    
    public CartDefinition withId(String id) {
        this.id = id;
        return this;
    }
    
    @Override
    public String getId() {
        return this.id;
    }
    
    @Override
    public ItemListCalibratable getItemList() {
        return this.itemList;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
