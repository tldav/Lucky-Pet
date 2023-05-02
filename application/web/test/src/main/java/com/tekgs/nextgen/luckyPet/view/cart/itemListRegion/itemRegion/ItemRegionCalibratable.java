package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion;

public interface ItemRegionCalibratable {
    boolean equivalent(ItemRegionCalibratable comparator);

    String getProductPrice();

    String getProductDescription();
    
    String getLineItemTotal();

    String getLineItemQuantity();
}
