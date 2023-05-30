package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private String id;
    private final List<ItemCalibratable> itemList = new ArrayList<>();
    
    private CartDefinition(CartCalibratable cart) {
        if (cart != null) {
            this.itemList.addAll(cart.getItemList());
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
    public List<ItemCalibratable> getItemList() {
        return this.itemList;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
