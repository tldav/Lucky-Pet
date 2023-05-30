package com.luckypet.user.data.cart;

public class CartProvider {
    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get() {
        return CartRepository.getInstance().query(CartDefinition.getInstance());
    }
}
