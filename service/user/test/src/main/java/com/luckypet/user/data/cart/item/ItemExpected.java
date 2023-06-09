package com.luckypet.user.data.cart.item;

import com.luckypet.user.data.product.Product;

public class ItemExpected implements ItemCalibratable {
    private Integer quantity;
    private Product _product;

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public Product get_product() {
        return this._product;
    }

    @Override
    public boolean equivalent(ItemCalibratable comparator) {
        return false;
    }
}
