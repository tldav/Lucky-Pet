package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.data.cart.item.Item;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Item> items = new ArrayList<>();
    private final Integer id;
    
    private Cart(Integer id) {
        this.id = id;
    }
    
    private static boolean areEquivalent(Integer comparatorCartTotal, Integer thisTotal) {
        return comparatorCartTotal == null || thisTotal.equals(comparatorCartTotal);
    }
    
    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        List<ItemCalibratable> itemDefinitions = comparator.getItems();
        boolean isEquivalent = areEquivalent(comparator.getTotal(), this.getTotal());
        isEquivalent &= areEquivalent(comparator.getItemCount(), this.getItemCount());
        isEquivalent &= itemsAreEquivalent(itemDefinitions);
        return isEquivalent;
    }
    
    private boolean itemsAreEquivalent(List<ItemCalibratable> comparators) {
        List<ItemCalibratable> thisItems = new ArrayList<>(this.getItems());
        for (ItemCalibratable itemDefinition : comparators) {
            ItemCalibratable foundItem = null;
            for (ItemCalibratable candidate : thisItems) {
                if (candidate.equivalent(itemDefinition)) {
                    foundItem = candidate;
                    break;
                }
            }
            if (foundItem != null) {
                thisItems.remove(foundItem);
            } else {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Integer getId() {
        return this.id;
    }
    
    @Override
    public List<ItemCalibratable> getItems() {
        return new ArrayList<>(this.items);
    }
    
    @Override
    public Integer getTotal() {
        Integer totalInCents = 0;
        for (ItemCalibratable item : this.items) {
            if (item.getProduct().getPrice() != null) {
                totalInCents += item.getProduct().getPrice() * item.getQuantity();
            }
        }
        return totalInCents;
    }
    
    @Override
    public Integer getItemCount() {
        return this.items.size();
    }
}
