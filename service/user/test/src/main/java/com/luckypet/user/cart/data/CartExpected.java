package com.luckypet.user.cart.data;

public class CartExpected implements CartCalibratable {
    private final CartCalibratable cart;

    public CartExpected(CartCalibratable cart) {
        this.cart = cart;
    }

    public static CartExpected getInstance(CartCalibratable cart) {
        return new CartExpected(cart);
    }

    @Override
    public String getId() {
        return cart.getId();
    }
    
    @Override
    public String getUsername() {
        return null;
    }
    
    @Override
    public boolean equivalent(CartCalibratable cartDefinition) {
        return false;
    }
}
