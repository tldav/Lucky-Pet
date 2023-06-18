package com.tekgs.nextgen.luckyPet.data.cart.item;

import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

public interface ItemCalibratable {
    Integer getQuantity();
    
    ProductCalibratable getProduct();
    
    boolean equivalent(ItemCalibratable comparator);
}
