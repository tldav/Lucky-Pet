package com.tekgs.nextgen.luckyPet.view.cart.itemListRegion;

import com.tekgs.nextgen.luckyPet.view.cart.itemListRegion.itemRegion.ItemRegionCalibratable;

import java.util.List;

public interface ItemListRegionCalibratable {
    List<ItemRegionCalibratable> getItemRegions();

    String getCartEmptyMessage();
}
