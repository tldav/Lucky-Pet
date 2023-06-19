package com.tekgs.nextgen.luckyPet.view.financialDashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.LuckyPetView;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegion;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegionCalibratable;

public class FinancialDashboardView extends LuckyPetView implements FinancialDashboardViewCalibratable {
    private static final String RELATIVE_URL = "financial-dashboard";
    private static final String DESCRIPTION = "'Financial Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "financial-dashboard-view";
    
    public FinancialDashboardView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static FinancialDashboardView directNav() {
        new FinancialDashboardView().load();
        return UiView.expect(FinancialDashboardView.class);
    }
    
    @Override
    public RevenueListRegionCalibratable getRevenueListRegion() {
        return RevenueListRegion.getInstance(this.getElement());
    }
    
    @Override
    protected boolean areKeyElementsLoaded() {
        return true;
    }
    
    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
