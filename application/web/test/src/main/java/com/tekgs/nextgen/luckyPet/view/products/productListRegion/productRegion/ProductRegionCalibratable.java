package com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion;

public interface ProductRegionCalibratable {
    String getOutOfStockMessage();

    boolean equivalent(ProductRegionCalibratable comparator);
    
    String getId();

    String getPrice();

    String getProductDescription();

    Boolean isAddToCartEnabled();
}
