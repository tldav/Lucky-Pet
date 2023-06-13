package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.data.cart.item.Item;
import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    private final List<Item> items = new ArrayList<>();
    private final Integer id;
    
    private Cart(Integer id) {
        this.id = id;
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
    public List<ItemCalibratable> getItems() {
        return new ArrayList<>(this.items);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getItemCount() {
        return items.size();
    }

    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null) {
            return false;
        } else if (comparator.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        List<ItemCalibratable> itemDefinitions = comparator.getItems();
        boolean isEquivalent = areEquivalent(comparator.getTotal(), this.getTotal());
        isEquivalent &= areEquivalent(comparator.getItemCount(), this.getItemCount());
        isEquivalent &= areItemsEquivalent(itemDefinitions);
        return isEquivalent;
    }

    private static boolean areEquivalent(Integer comparatorCartTotal, Integer thisTotal) {
        return comparatorCartTotal == null || thisTotal.equals(comparatorCartTotal);
    }

    private boolean areItemsEquivalent(List<ItemCalibratable> comparators) {
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
}
