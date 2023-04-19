package com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion.LowStockRegion;
import com.tekgs.nextgen.luckyPet.view.inventoryDashboard.lowStockListRegion.lowStockRegion.LowStockRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class LowStockListRegion extends UiRegion implements LowStockListRegionCalibratable {
    
    private static final String DESCRIPTION = "'Low Inventory' region ";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "low-stock-list-region";
    
    private LowStockListRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }
    
    public static LowStockListRegion getInstance(UiElement parent) {
        return new LowStockListRegion(parent);
    }
    
    @Override
    public List<LowStockRegionCalibratable> getLowStockRegions() {
        List<LowStockRegionCalibratable> lowStockRegions = new ArrayList<>();
        List<UiElement> lowStockElementList = UiElement.getList("'Low Stock' region", UiLocatorType.CLASS, "low-stock-region",
                this.getElement());
        for (UiElement lowStockElement : lowStockElementList) {
            lowStockRegions.add(LowStockRegion.getInstance(lowStockElement));
        }
        return lowStockRegions;
    }
}
