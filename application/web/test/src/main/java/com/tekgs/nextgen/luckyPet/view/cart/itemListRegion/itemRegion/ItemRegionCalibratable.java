package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

public interface ItemRegionCalibratable {
    
    String getLineItemQuantity();
    
    String getProductPrice();
    
    String getProductDescription();
    
    String getLineItemTotal();
    
    boolean equivalent(ItemRegionCalibratable comparator);
    
}
