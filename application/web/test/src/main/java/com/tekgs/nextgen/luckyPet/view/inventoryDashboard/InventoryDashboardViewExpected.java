package com.tekgs.nextgen.luckyPet.view.inventoryDashboard;

import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegionExpected;

public class InventoryDashboardViewExpected implements InventoryDashboardViewCalibratable {
    
    public static InventoryDashboardViewExpected getInstance() {
        return new InventoryDashboardViewExpected();
    }

    @Override
    public LowStockListRegionCalibratable getLowStockListRegion() {
        return LowStockListRegionExpected.getInstance();
    }
}
