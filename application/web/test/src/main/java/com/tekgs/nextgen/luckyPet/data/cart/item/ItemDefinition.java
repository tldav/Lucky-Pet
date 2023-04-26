package com.tekgs.nextgen.luckyPet.data.cart.item;

import com.tekgs.nextgen.luckyPet.data.product.Product;
import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

public class ItemDefinition implements ItemCalibratable {
    private Integer quantity;
    private ProductCalibratable product;
    
    private ItemDefinition() {
    
    }
    
    public static ItemDefinition getInstance() {
        return new ItemDefinition();
    }
    
    public ItemDefinition withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
    
    public ItemDefinition withProduct(ProductCalibratable product) {
        this.product = product;
        return this;
    }
    
    @Override
    public Integer getQuantity() {
        return this.quantity;
    }
    
    @Override
    public ProductCalibratable getProduct() {
        return this.product;
    }
    
    @Override
    public boolean equivalent(ItemCalibratable comparator) {
        return false;
    }

    @Override
    public Integer getLineItemTotal() {
        return null;
    }
}
