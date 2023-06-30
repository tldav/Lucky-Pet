package com.luckypet.user.data.cart.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.luckypet.user.data.product.Product;

@JsonDeserialize(as = Item.class)
public class Item implements ItemCalibratable {

    private Integer quantity;
    private Product product;

    public Item() {
    }

    private Item(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public static Item getInstance(ItemDefinition itemDefinition) {
        return new Item(itemDefinition.getQuantity(), itemDefinition.getProduct());
    }

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
        if (comparator == null){
            return false;
        }

        boolean isEquivalent = this.product.equivalent(comparator.getProduct());
        isEquivalent &= comparator.getQuantity() == null || this.quantity.equals(comparator.getQuantity());

        return isEquivalent;
    }
}
