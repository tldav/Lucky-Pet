package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

import com.tekgs.nextgen.luckyPet.data.cart.item.ItemCalibratable;
import com.tekgs.nextgen.luckyPet.data.financial.Cents;

public class ItemRegionExpected implements ItemRegionCalibratable {
    private final ItemCalibratable item;
    
    public ItemRegionExpected(ItemCalibratable item) {
        this.item = item;
    }
    
    public static ItemRegionExpected getInstance(ItemCalibratable item) {
        return new ItemRegionExpected(item);
    }
    
    @Override
    public boolean equivalent(ItemRegionCalibratable comparator) {
        return false;
    }
    
    @Override
    public String getPrice() {
        Cents price = Cents.getInstance(this.item.getProduct().getPrice());
        return price.inUsdFormat();
    }
    
    @Override
    public String getItemDescription() {
        return item.getProduct().getDescription();
    }
}
