package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.Item;
import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {

    private Integer id;
    private List<Item> itemList = new ArrayList<>();

    public Cart() {
    }
    public Integer getId() {
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
        return new ArrayList<>(this.itemList);
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
