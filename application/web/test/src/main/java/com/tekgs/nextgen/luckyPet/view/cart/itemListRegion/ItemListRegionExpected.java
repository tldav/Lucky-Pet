package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion;

import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class ItemListRegionExpected implements ItemListRegionCalibratable {

    private final List<ProductCalibratable> items;

    public ItemListRegionExpected(List<ProductCalibratable> items) {
        this.items= items;
    }

    public static ItemListRegionCalibratable getInstance(List<ProductCalibratable> items) {
        return new ItemListRegionExpected(items);
    }

    @Override
    public List<ItemRegionCalibratable> getItemRegions() {
        ArrayList<ItemRegionCalibratable> itemRegions = new ArrayList<>();
        for (ProductCalibratable item : this.items) {
            itemRegions.add(ItemRegionExpected.getInstance(item));
        }
        return itemRegions;
    }

    @Override
    public String getCartEmptyMessage() {
        return this.items.isEmpty() ? "Cart is empty" : null;
    }
}
