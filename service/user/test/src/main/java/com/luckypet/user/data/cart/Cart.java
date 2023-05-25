package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.Item;
import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.List;

public class Cart implements CartCalibratable {
    private String id;
    private List<ItemCalibratable> itemList;
    
    public String getId() {
        return this.id;
    }
    
    @Override
    public List<ItemCalibratable> getItemList() {
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
