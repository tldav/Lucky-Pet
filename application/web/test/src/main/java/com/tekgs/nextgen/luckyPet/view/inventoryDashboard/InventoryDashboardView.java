package com.tekgs.nextgen.luckyPet.view.inventoryDashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegion;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegionCalibratable;

public class InventoryDashboardView extends LuckyPetView implements InventoryDashboardViewCalibratable {
    private static final String RELATIVE_URL = "inventory-dashboard";
    private static final String DESCRIPTION = "'Inventory Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "inventory-dashboard-view";
    
    public InventoryDashboardView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static InventoryDashboardView directNav() {
        new InventoryDashboardView().load();
        return LuckyPetView.expect(InventoryDashboardView.class);
    }
    
    @Override
    public LowStockListRegionCalibratable getLowStockListRegion() {
        return LowStockListRegion.getInstance(this.getElement());
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
}
