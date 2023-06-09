package com.luckypet.user.service.cart;

import com.luckypet.user.data.cart.CartCalibratable;
import com.luckypet.user.data.cart.CartExpected;

public class CartResponseExpected implements CartResponseCalibratable {
    private final CartExpected cartExpected;
    
    private CartResponseExpected(CartExpected cartExpected) {
//        if(cartExpected == null){
//            this.cartExpected = CartExpected.getInstance(CartProvider.getInstance().get());
//        }
//        else{
//            this.cartExpected = cartExpected;
//        }
        this.cartExpected = cartExpected;
    }
    
    public static CartResponseExpected getInstance() {
        return new CartResponseExpected(null);
    }
    
    public static CartResponseExpected getInstance(CartExpected cartExpected) {
        return new CartResponseExpected(cartExpected);
    }

    @Override
    public Boolean isSuccessful() {
        return true;
    }
    
    @Override
    public CartCalibratable getCart() {
        return this.cartExpected;
    }
}