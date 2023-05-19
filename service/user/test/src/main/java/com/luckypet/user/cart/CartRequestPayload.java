package com.luckypet.user.cart;

import com.luckypet.user.cart.data.CartCalibratable;

public class CartRequestPayload {
    private final CartCalibratable cart;

    public CartRequestPayload(CartCalibratable cart) {
        this.cart = cart;
    }

    public static CartRequestPayload getInstance(CartCalibratable cart) {
        return new CartRequestPayload(cart);
    }

    public CartCalibratable getCart() {
        return this.cart;
    }
}
