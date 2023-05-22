package com.luckypet.user.cart.data;

public class CartProvider {
    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable cartDefinition) {
        return CartRepository.getInstance().query(cartDefinition);
    }
}
