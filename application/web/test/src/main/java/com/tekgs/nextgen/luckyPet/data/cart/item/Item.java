package com.tekgs.nextgen.luckyPet.data.cart.item;

import com.tekgs.nextgen.luckyPet.data.product.Product;

public class Item implements ItemCalibratable {
    private final Integer quantity;
    private final Product product;
    
    private Item(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
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
        return false;
    }
}
