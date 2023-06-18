package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion;

import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ItemListRegionExpected implements ItemListRegionCalibratable {
    
    private final List<ItemCalibratable> items;
    
    public ItemListRegionExpected(List<ItemCalibratable> items) {
        this.items = items;
    }
    
    public static ItemListRegionCalibratable getInstance(List<ItemCalibratable> items) {
        return new ItemListRegionExpected(items);
    }
    
    @Override
    public String getCartEmptyMessage() {
        return this.items.isEmpty() ? "Cart is empty" : null;
    }
    
    @Override
    public List<ItemRegionCalibratable> getItemRegions() {
        ArrayList<ItemRegionCalibratable> itemRegions = new ArrayList<>();
        for (ItemCalibratable item : this.items) {
            itemRegions.add(ItemRegionExpected.getInstance(item));
        }
        return itemRegions;
    }
}
