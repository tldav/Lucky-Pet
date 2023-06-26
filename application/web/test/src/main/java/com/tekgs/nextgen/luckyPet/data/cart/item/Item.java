package com.tekgs.nextgen.luckyPet.data.cart.item;

import com.tekgs.nextgen.luckyPet.data.product.Product;

public class Item implements ItemCalibratable {
    private final Integer quantity;
    private final Product product;
    
    private Item(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
    
    static Item getInstance(ItemDefinition definition) {
        return new Item(definition.getQuantity(), (Product) definition.getProduct());
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
        if (comparator == null) {
            return false;
        }
        
        boolean isEquivalent = comparator.getQuantity() == null || this.quantity.equals(comparator.getQuantity());
        isEquivalent &= comparator.getProduct() == null || this.product.equivalent(comparator.getProduct());
        return isEquivalent;
    }
}
