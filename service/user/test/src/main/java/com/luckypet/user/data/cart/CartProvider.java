package com.luckypet.user.data.cart;

public class CartProvider {
    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable cartDefinition) {
        return CartRepository.getInstance().query(cartDefinition);
    }
}
