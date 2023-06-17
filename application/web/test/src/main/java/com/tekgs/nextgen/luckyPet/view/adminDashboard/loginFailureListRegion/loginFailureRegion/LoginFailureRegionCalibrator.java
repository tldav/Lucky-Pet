package com.tekgs.nextgen.luckyPet.view.adminDashboard.loginFailureListRegion.loginFailureRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LoginFailureRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Failure Date' region";
    private final LoginFailureRegionCalibratable actual;
    private final LoginFailureRegionCalibratable expected;

    private LoginFailureRegionCalibrator(LoginFailureRegionCalibratable expected, LoginFailureRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static LoginFailureRegionCalibrator getInstance(LoginFailureRegionCalibratable expected, LoginFailureRegionCalibratable actual) {
        return new LoginFailureRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Date", expected.getDate(), actual.getDate());
        verify("Count", expected.getFailureCount(), actual.getFailureCount());
    }
}
