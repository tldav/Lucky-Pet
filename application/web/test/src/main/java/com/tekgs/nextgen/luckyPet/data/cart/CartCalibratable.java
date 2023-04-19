package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

import java.util.List;

public interface CartCalibratable {
    Integer getCartTotal();

    List<ProductCalibratable> getItems();

    String getId();

    Integer getItemCount();
}
