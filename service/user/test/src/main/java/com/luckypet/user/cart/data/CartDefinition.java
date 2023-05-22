package com.luckypet.user.cart.data;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private final List<ItemCalibratable> items = new ArrayList<>();
    private String id;

    public CartDefinition(CartCalibratable cart) {
        if(cart != null){
            this.items.addAll(cart.getItems());
            this.id = cart.getId();
        }
    }

    public static CartCalibratable getInstance() {
        return new CartDefinition(null);
    }

    @Override
    public String getId() {
        return this.id;
    }
}
