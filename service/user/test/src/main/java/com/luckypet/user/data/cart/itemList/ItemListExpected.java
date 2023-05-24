package com.luckypet.user.data.cart.itemList;

import com.luckypet.user.data.cart.itemList.item.ItemCalibratable;

import java.util.List;

public class ItemListExpected implements ItemListCalibratable {
    private List<ItemCalibratable> itemListExpected;
    
    @Override
    public List<ItemCalibratable> getItems() {
        return this.itemListExpected;
    }
}
