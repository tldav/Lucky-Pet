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
    
    private int calculateLineItemTotal() {
        return this.item.getQuantity() * this.item.getProduct().getPrice();
    }
    
    @Override
    public String getLineItemQuantity() {
        return String.valueOf(this.item.getQuantity());
    }
    
    @Override
    public String getProductPrice() {
        Cents price = Cents.getInstance(this.item.getProduct().getPrice());
        return price.inUsdFormat();
    }
    
    @Override
    public String getProductDescription() {
        return this.item.getProduct().getDescription();
    }
    
    @Override
    public String getLineItemTotal() {
        return Cents.getInstance(calculateLineItemTotal()).inUsdFormat();
    }
    
    @Override
    public boolean equivalent(ItemRegionCalibratable comparator) {
        return false;
    }
}
