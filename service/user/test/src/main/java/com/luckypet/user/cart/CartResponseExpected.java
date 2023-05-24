package com.luckypet.user.cart;

import com.luckypet.user.cart.data.Cart;
import com.luckypet.user.cart.data.CartCalibratable;
import com.luckypet.user.cart.data.CartExpected;

import java.util.ArrayList;
import java.util.List;

public class CartResponseExpected implements CartResponseCalibratable {
    private final List<CartCalibratable> carts;
    
    private CartResponseExpected(List<CartExpected> cartExpectedList) {
        this.carts = new ArrayList<>();
        
        if (cartExpectedList != null) {
            this.carts.addAll(cartExpectedList);
        }
    }
    
    public static CartResponseExpected getInstance() {
        return new CartResponseExpected(null);
    }
    
    public static CartResponseExpected getInstance(CartExpected cartExpected) {
        List<CartExpected> cartExpectedList = new ArrayList<>();
        cartExpectedList.add(cartExpected);
        return new CartResponseExpected(cartExpectedList);
    }
    
    public static CartResponseExpected getInstance(List<CartExpected> cartExpectedList) {
        return new CartResponseExpected(cartExpectedList);
    }
    
    @Override
    public boolean isSuccessful() {
        return true;
    }
    
    @Override
    public List<CartCalibratable> getCarts() {
        return this.carts;
    }
}
