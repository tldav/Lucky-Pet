package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    String getId();
    List<ItemCalibratable> getItemList();
    boolean equivalent(CartCalibratable cartDefinition);
}
