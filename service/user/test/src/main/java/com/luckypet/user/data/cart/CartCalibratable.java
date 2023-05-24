package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.itemList.ItemListCalibratable;

public interface CartCalibratable {
    String getId();
    
    ItemListCalibratable getItemList();
    
    boolean equivalent(CartCalibratable cartDefinition);
    
}
