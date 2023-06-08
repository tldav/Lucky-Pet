package com.luckypet.user.data.cart.item;

import com.luckypet.user.data.product.Product;

public class ItemDefinition implements ItemCalibratable {
    private Integer quantity;
    private Product product;

    public ItemDefinition withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemDefinition withProduct(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public Product get_product() {
        return this.product;
    }

    @Override
    public boolean equivalent(ItemCalibratable comparator) {
        return false;
    }
}
