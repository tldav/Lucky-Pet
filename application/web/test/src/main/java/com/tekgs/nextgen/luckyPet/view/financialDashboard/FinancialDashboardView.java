package com.tekgs.nextgen.luckyPet.view.financialDashboard;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegion;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegionCalibratable;
import org.softwareonpurpose.gauntlet.Environment;

public class FinancialDashboardView extends UiView implements FinancialDashboardViewCalibratable {

    private static final String LOCATOR_VALUE = "financial-dashboard-view";
    private static final String DOMAIN_URL = Environment.getInstance().getDomainUrl();
    private static final String RELATIVE_URL = "financial-dashboard";
    private static final String VIEW_URL = String.format("%s/%s", DOMAIN_URL, RELATIVE_URL);
    private static final String DESCRIPTION = "'Financial Dashboard' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;

    public FinancialDashboardView() {
        super(VIEW_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static FinancialDashboardView directNav() {
        new FinancialDashboardView().load();
        return UiView.expect(FinancialDashboardView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return true;
    }

    @Override
    public RevenueListRegionCalibratable getRevenueListRegion() {
        return RevenueListRegion.getInstance(this.getElement());
    }
}
