package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final Integer id;
    private final List<ItemCalibratable> itemListExpected;
    
    public CartExpected(Cart cart) {
        this.itemListExpected = new ArrayList<>(cart.getItemList());
        this.id = cart.getId();
    }
    
    public static CartExpected getInstance(Cart cart) {
        return new CartExpected(cart);
    }
    
    @Override
    public Integer getId() {
        return this.id;
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
