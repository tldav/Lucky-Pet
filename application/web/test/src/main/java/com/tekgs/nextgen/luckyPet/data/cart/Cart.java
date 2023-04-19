package com.tekgs.nextgen.luckyPet.data.cart;

import com.tekgs.nextgen.luckyPet.data.product.Product;
import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    private final List<Product> items = new ArrayList<>();
    private final String id;
    
    private Cart(String id) {
        this.id = id;
    }
    
    private static boolean areEquivalent(Integer comparatorCartTotal, Integer thisTotal) {
        return comparatorCartTotal == null || thisTotal.equals(comparatorCartTotal);
    }

    @Override
    public Integer getCartTotal() {
        Integer totalInCents = 0;
        for (ProductCalibratable item : this.items) {
            if (item.getPrice() != null) {
            totalInCents += item.getPrice();
            }
        }
        return totalInCents;
    }

    @Override
    public List<ProductCalibratable> getItems() {
        return new ArrayList<>(this.items);
    }

    @Override
    public String getId() {
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
        List<ProductCalibratable> itemDefinitions = comparator.getItems();
        boolean isEquivalent = areEquivalent(comparator.getCartTotal(), this.getCartTotal());
        isEquivalent &= areEquivalent(comparator.getItemCount(), this.getItemCount());
        isEquivalent &= areItemsEquivalent(itemDefinitions);
        return isEquivalent;
    }

    private boolean areItemsEquivalent(List<ProductCalibratable> comparators) {
        List<ProductCalibratable> thisItems = new ArrayList<>(this.getItems());
        for (ProductCalibratable itemDefinition : comparators) {
            ProductCalibratable foundItem = null;
            for (ProductCalibratable candidate : thisItems) {
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
