package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

import com.tekgs.nextgen.luckyPet.data.financial.Cents;
import com.tekgs.nextgen.luckyPet.data.product.ProductCalibratable;

public class ItemRegionExpected implements ItemRegionCalibratable {
    private final ProductCalibratable item;
    
    public ItemRegionExpected(ProductCalibratable item) {
        this.item = item;
    }
    
    public static ItemRegionExpected getInstance(ProductCalibratable item) {
        return new ItemRegionExpected(item);
    }
    
    @Override
    public boolean equivalent(ItemRegionCalibratable comparator) {
        return false;
    }
    
    @Override
    public String getPrice() {
        Cents price = Cents.getInstance(this.item.getPrice());
        return price.inUsdFormat();
    }
    
    @Override
    public String getItemDescription() {
        return item.getDescription();
    }
}
