package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion;

public interface LowStockRegionCalibratable {
    String getProductPrice();
    
    String getProductDescription();
    
    String getProductStock();
    
    boolean equivalent(LowStockRegionCalibratable comparator);
}
