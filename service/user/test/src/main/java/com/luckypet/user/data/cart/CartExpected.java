package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final Cart cartExpected;
//    private final List<ItemCalibratable> itemListExpected;
    
    public CartExpected(Cart cart) {
        this.cartExpected = cart;
//        this.itemListExpected = new ArrayList<>();
//        if (cart != null) {
//            this.itemListExpected.addAll(cart.getItemList());
//        }
    }
    
    public static CartExpected getInstance(Cart cart) {
        return new CartExpected(cart);
    }
    
    @Override
    public Integer getId() {
        return this.cartExpected.getId();
    }
    
    @Override
    public List<ItemCalibratable> getItemList() {
        if(this.cartExpected == null){
            return new ArrayList<>();
        }
        return this.cartExpected.getItemList();
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
