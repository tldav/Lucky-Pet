package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class FailedLoginRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Failure Date' region";
    private final FailedLoginRegionCalibratable actual;
    private final FailedLoginRegionCalibratable expected;

    private FailedLoginRegionCalibrator(FailedLoginRegionCalibratable expected, FailedLoginRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static FailedLoginRegionCalibrator getInstance(FailedLoginRegionCalibratable expected, FailedLoginRegionCalibratable actual) {
        return new FailedLoginRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Date", expected.getDate(), actual.getDate());
        verify("Count", expected.getFailureCount(), actual.getFailureCount());
    }
}
