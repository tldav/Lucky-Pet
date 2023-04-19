package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion;

public interface LowStockRegionCalibratable {
    boolean equivalent(LowStockRegionCalibratable comparator);

    String getProductStock();

    String getProductDescription();

    String getProductPrice();
}
