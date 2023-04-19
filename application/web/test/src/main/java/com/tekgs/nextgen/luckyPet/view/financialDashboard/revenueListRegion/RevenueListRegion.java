package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion.RevenueRegion;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion.RevenueRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class RevenueListRegion extends UiRegion implements RevenueListRegionCalibratable {
    private static final String DESCRIPTION = "'Revenue List' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "revenue-list-region";
    
    private RevenueListRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }
    
    public static RevenueListRegionCalibratable getInstance(UiElement parent) {
        return new RevenueListRegion(parent);
    }
    
    @Override
    public List<RevenueRegionCalibratable> getRevenueRegions() {
        List<RevenueRegionCalibratable> revenueRegions = new ArrayList<>();
        List<UiElement> revenueElementList = UiElement.getList("'Revenue' region", UiLocatorType.CLASS, "revenue-region", this.getElement());
        for (UiElement revenueElement : revenueElementList) {
            revenueRegions.add(RevenueRegion.getInstance(revenueElement));
        }
        return revenueRegions;
    }
}
