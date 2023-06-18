package com.tekgs.nextgen.luckyPet.view.products.productListRegion.productRegion;

public interface ProductRegionCalibratable {
    String getId();
    
    String getPrice();
    
    String getProductDescription();
    
    String getOutOfStockMessage();
    
    Boolean isAddToCartEnabled();
    
    boolean equivalent(ProductRegionCalibratable comparator);
}
