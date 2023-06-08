package com.luckypet.user.data.cart.item;

import com.luckypet.user.data.product.Product;

public class Item implements ItemCalibratable {

    private Integer quantity;
    private Product _product;

    public Item() {
    }
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
        if (comparator == null){
            return false;
        }

        boolean isEquivalent = this._product.equivalent(comparator.get_product());
        isEquivalent &= comparator.getQuantity() == null || this.quantity.equals(comparator.getQuantity());

        return isEquivalent;
    }
}
