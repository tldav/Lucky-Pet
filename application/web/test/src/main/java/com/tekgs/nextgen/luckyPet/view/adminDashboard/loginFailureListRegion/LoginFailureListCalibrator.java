package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion.LoginFailureRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion.LoginFailureRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class LoginFailureListCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Failed Login' report";
    
    private LoginFailureListCalibrator(LoginFailureListRegionExpected expected, LoginFailureListRegion actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        List<LoginFailureRegionCalibratable> actualFailureDates = new ArrayList<>(actual.getLoginFailureRegions());
        for (LoginFailureRegionCalibratable expectedFailureDate : expected.getLoginFailureRegions()) {
            LoginFailureRegionCalibratable foundFailureDate = null;
            for (LoginFailureRegionCalibratable candidate : actualFailureDates) {
                if (candidate.equivalent(expectedFailureDate)) {
                    foundFailureDate = candidate;
                    addChildCalibrator(LoginFailureRegionCalibrator.getInstance(expectedFailureDate, candidate));
                    break;
                }
            }
            if (foundFailureDate == null) {
                System.out.println("not found");
                addChildCalibrator(LoginFailureRegionCalibrator.getInstance(expectedFailureDate, foundFailureDate));
            } else {
                actualFailureDates.remove(foundFailureDate);
            }
        }
        for (LoginFailureRegionCalibratable unexpectedFailureDate : actualFailureDates) {
            addChildCalibrator(LoginFailureRegionCalibrator.getInstance(null, unexpectedFailureDate));
        }
        UiRegion.suppressConstructionLogging(false);
    }
    
    public static LoginFailureListCalibrator getInstance(LoginFailureListRegionExpected expected, LoginFailureListRegion actual) {
        return new LoginFailureListCalibrator(expected, actual);
    }
    
    @Override
    protected void executeVerifications() {
    
    }
}
