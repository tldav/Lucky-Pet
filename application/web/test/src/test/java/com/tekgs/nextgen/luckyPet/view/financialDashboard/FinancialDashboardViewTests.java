package com.tekgs.nextgen.luckyPet.view.financialDashboard;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.FINANCIAL_DASHBOARD})
public class FinancialDashboardViewTests extends GauntletTest {
    
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        addRequirements("69-Financial-Dashboard-gross-revenue");
        FinancialDashboardView actual = FinancialDashboardView.directNav();
        FinancialDashboardViewExpected expected = FinancialDashboardViewExpected.getInstance();
        then(FinancialDashboardViewCalibrator.getInstance(expected, actual));
    }
}


