package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    Integer getCartTotal();

    List<ItemCalibratable> getItems();

    String getId();

    Integer getItemCount();
}
