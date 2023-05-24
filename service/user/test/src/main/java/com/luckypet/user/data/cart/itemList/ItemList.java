package com.luckypet.user.data.cart.itemList;

import com.luckypet.user.data.cart.itemList.item.ItemCalibratable;

import java.util.List;

public class ItemList implements ItemListCalibratable {
    List<ItemCalibratable> itemList;
    
    @Override
    public List<ItemCalibratable> getItems() {
        return this.itemList;
    }
}
