package com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion.FailedLoginRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.adminDashboard.failedLoginListRegion.failedLoginRegion.FailedLoginRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class FailedLoginReportCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Failed Login' report";

    private FailedLoginReportCalibrator(FailedLoginReportExpected expected, FailedLoginListRegion actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        List<FailedLoginRegionCalibratable> actualFailureDates = new ArrayList<>(actual.getFailureDates());
        for (FailedLoginRegionCalibratable expectedFailureDate : expected.getFailureDates()) {
            FailedLoginRegionCalibratable foundFailureDate = null;
            for (FailedLoginRegionCalibratable candidate : actualFailureDates) {
                if (candidate.equivalent(expectedFailureDate)) {
                    foundFailureDate = candidate;
                    addChildCalibrator(FailedLoginRegionCalibrator.getInstance(expectedFailureDate, candidate));
                    break;
                }
            }
            if (foundFailureDate == null) {
                System.out.println("not found");
                addChildCalibrator(FailedLoginRegionCalibrator.getInstance(expectedFailureDate, foundFailureDate));
            } else {
                actualFailureDates.remove(foundFailureDate);
            }
        }
        for (FailedLoginRegionCalibratable unexpectedFailureDate : actualFailureDates) {
            addChildCalibrator(FailedLoginRegionCalibrator.getInstance(null, unexpectedFailureDate));
        }
        UiRegion.suppressConstructionLogging(false);
    }

    public static FailedLoginReportCalibrator getInstance(FailedLoginReportExpected expected, FailedLoginListRegion actual) {
        return new FailedLoginReportCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
