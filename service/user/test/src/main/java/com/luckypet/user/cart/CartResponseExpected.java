package com.luckypet.user.cart;

import com.luckypet.user.cart.data.CartExpected;

public class CartResponseExpected implements CartResponseCalibratable{
    public CartResponseExpected(CartExpected cartExpected) {
    }

    public static CartResponseExpected getInstance() {
        return new CartResponseExpected(null);
    }
    
    public static CartResponseExpected getInstance(CartExpected cartExpected) {
        return new CartResponseExpected(cartExpected);
    }
    
    @Override
    public boolean isSuccessful() {
        return true;
    }
}
