package com.tekgs.nextgen.luckyPet.data.cart.item;

import com.tekgs.nextgen.luckyPet.data.product.Product;

public interface ItemCalibratable {
    Integer getQuantity();
    Product getProduct();
    
    boolean equivalent(ItemCalibratable comparator);
}
