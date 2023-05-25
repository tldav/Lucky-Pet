package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.List;

public class Cart implements CartCalibratable {
    private String id;
    private List<ItemCalibratable> itemList;
    
    public String getId() {
        return this.id;
    }
    
    private boolean itemsAreEquivalent(List<ItemCalibratable> comparatorItemList) {
        boolean areEquivalent = true;
        for (ItemCalibratable comparatorItem : comparatorItemList) {
            for (ItemCalibratable item : this.itemList) {
                if (!item.equivalent(comparatorItem)) {
                    areEquivalent = false;
                    break;
                }
            }
        }
        return areEquivalent;
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
        
        return itemsAreEquivalent(comparator.getItemList());
    }
}
