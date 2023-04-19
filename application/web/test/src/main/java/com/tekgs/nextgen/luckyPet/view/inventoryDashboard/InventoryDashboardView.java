package com.tekgs.nextgen.luckyPet.view.inventoryDashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegion;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.LowStockListRegionCalibratable;
import org.softwareonpurpose.gauntlet.Environment;

public class InventoryDashboardView extends UiView implements InventoryDashboardViewCalibratable {
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "inventory-dashboard";
    private static final String VIEW_URL = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);
    private static final String DESCRIPTION = "'Inventory Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "inventory-dashboard-view";
    
    public InventoryDashboardView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static InventoryDashboardView directNav() {
        new InventoryDashboardView().load();
        return UiView.expect(InventoryDashboardView.class);
    }
    
    @Override
    protected boolean confirmElementStates() {
        return true;
    }
    
    @Override
    public LowStockListRegionCalibratable getLowStockListRegion() {
        return LowStockListRegion.getInstance(this.getElement());
    }
}
