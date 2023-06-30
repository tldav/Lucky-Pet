package com.luckypet.user.data.cart;

import com.luckypet.user.data.cart.item.Item;
import com.luckypet.user.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    
    private Integer id;
    private List<ItemCalibratable> itemList = new ArrayList<>();
    
    public Cart() {
    }

    private Cart(Integer id, List<ItemCalibratable> itemList) {
        this.id = id;
        this.itemList = itemList;
    }

    public static Cart getInstance(CartDefinition cartDefinition) {
        return new Cart(cartDefinition.getId(), cartDefinition.getItemList());
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
    
    public Integer getId() {
        return this.id;
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
