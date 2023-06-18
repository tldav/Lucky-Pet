package com.tekgs.nextgen.luckyPet.view.financialDashboard;

import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegionExpected;

public class FinancialDashboardViewExpected implements FinancialDashboardViewCalibratable {
    
    private FinancialDashboardViewExpected() {
    }
    
    public static FinancialDashboardViewExpected getInstance() {
        return new FinancialDashboardViewExpected();
    }
    
    @Override
    public RevenueListRegionCalibratable getRevenueListRegion() {
        return RevenueListRegionExpected.getInstance();
    }
}
