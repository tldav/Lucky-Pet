package com.tekgs.nextgen.luckyPet.view.adminDashboard;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.LoginFailureListCalibrator;

public class AdminDashboardViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Admin Dashboard' view";
    
    private AdminDashboardViewCalibrator(AdminDashboardViewExpected expected, AdminDashboardView actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(LoginFailureListCalibrator.getInstance(expected.getLoginFailureListRegion(), actual.getLoginFailureListRegion()));
        UiRegion.suppressConstructionLogging(false);
    }
    
    public static AdminDashboardViewCalibrator getInstance(AdminDashboardViewExpected expected, AdminDashboardView actual) {
        return new AdminDashboardViewCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
    }
}
