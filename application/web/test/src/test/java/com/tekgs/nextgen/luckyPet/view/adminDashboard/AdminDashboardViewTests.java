package com.tekgs.nextgen.luckyPet.view.adminDashboard;

import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.LUCKY_PET_WEB, GauntletTest.View.LOGIN_FAILURE})
public class AdminDashboardViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {"failedLoginReportTwentyEightDaysMissingOne"},
                {"failedLoginReportMoreThanTwentyEightDays"},
                {"failedLoginReportLessThanTwentyEightDays"}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        AdminDashboardViewExpected expected = AdminDashboardViewExpected.getInstance();
        AdminDashboardView actual = AdminDashboardView.directNav();
        then(AdminDashboardViewCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(String loginFailureLogFile) {
        given(loginFailureLogFile);
        AdminDashboardViewExpected expected = AdminDashboardViewExpected.getInstance(loginFailureLogFile);
        when();
        AdminDashboardView actual = AdminDashboardView.directNav(loginFailureLogFile);
        then(AdminDashboardViewCalibrator.getInstance(expected, actual));
    }
}
