package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    Integer getId();
    
    List<ItemCalibratable> getItemList();
    
    Integer getTotal();
    
    Integer getItemCount();
}
