package com.luckypet.user.data.cart.item;

import com.luckypet.user.data.cart.item.product.Product;

public class Item implements ItemCalibratable {
    private Integer quantity;
    private Product product;

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public boolean equivalent(ItemCalibratable comparator) {
        return false;
    }
}
