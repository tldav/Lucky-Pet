package com.tekgs.nextgen.luckyPet.view.cart;

import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.ItemListRegionCalibratable;

public interface CartViewCalibratable {
    String getTotal();
    
    ItemListRegionCalibratable inItemListRegion();
}
