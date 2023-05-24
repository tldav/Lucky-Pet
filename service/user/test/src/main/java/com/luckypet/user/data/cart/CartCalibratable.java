package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.itemList.ItemListCalibratable;
import com.luckypet.user.data.cart.itemList.item.Item;
import com.luckypet.user.data.cart.itemList.item.ItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    String getId();
    
    String getUsername();
    
    boolean equivalent(CartCalibratable cartDefinition);

    ItemListCalibratable getItemList();
}
