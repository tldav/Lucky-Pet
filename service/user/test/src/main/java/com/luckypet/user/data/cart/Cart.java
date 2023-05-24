package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.itemList.ItemList;
import com.luckypet.user.data.cart.itemList.ItemListCalibratable;

public class Cart implements CartCalibratable {
    private String id;
    private ItemList itemList;
    
    public String getId() {
        return this.id;
    }
    
    @Override
    public ItemListCalibratable getItemList() {
        return this.itemList;
    }
    
    @Override
    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() != null && this.id.equals(comparator.getId())) {
            return true;
        }
        // will need to address item equivalence
        return false;
    }
}
