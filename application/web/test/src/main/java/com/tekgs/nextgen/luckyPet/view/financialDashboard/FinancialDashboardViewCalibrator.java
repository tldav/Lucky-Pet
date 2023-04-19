package com.tekgs.nextgen.luckyPet.view.financialDashboard;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.RevenueListRegionCalibrator;

public class FinancialDashboardViewCalibrator extends  Calibrator{
    private static final String DESCRIPTION = "'Financial Dashboard' view";

    protected FinancialDashboardViewCalibrator(FinancialDashboardViewExpected expected, FinancialDashboardView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        this.addChildCalibrator(RevenueListRegionCalibrator.getInstance(expected.getRevenueListRegion(),actual.getRevenueListRegion()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static FinancialDashboardViewCalibrator getInstance(FinancialDashboardViewExpected expected, FinancialDashboardView actual) {
        return new FinancialDashboardViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
