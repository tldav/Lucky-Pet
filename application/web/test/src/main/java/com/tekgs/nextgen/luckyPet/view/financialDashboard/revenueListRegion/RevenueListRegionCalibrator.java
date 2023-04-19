package com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion.RevenueRegionCalibratable;
import com.tekgs.nextgen.luckyPet.view.financialDashboard.revenueListRegion.revenueRegion.RevenueRegionCalibrator;

import java.util.List;

public class RevenueListRegionCalibrator extends Calibrator{
    private static final String DESCRIPTION = "'Revenue List' region";

    private RevenueListRegionCalibrator(RevenueListRegionCalibratable expected, RevenueListRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        List<RevenueRegionCalibratable> revenueRegionsExpected = expected.getRevenueRegions();
        List<RevenueRegionCalibratable> revenueRegionsActual = actual.getRevenueRegions() ;
        addCalibrationsExpected(revenueRegionsExpected, revenueRegionsActual);
        addCalibrationsUnexpected(revenueRegionsActual);
        UiRegion.suppressConstructionLogging(false);
    }

    public static RevenueListRegionCalibrator getInstance(RevenueListRegionCalibratable expected, RevenueListRegionCalibratable actual) {
        return new RevenueListRegionCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<RevenueRegionCalibratable> revenueRegionsExpected, List<RevenueRegionCalibratable> revenueRegionsActual) {
        for (RevenueRegionCalibratable revenueRegionExpected : revenueRegionsExpected) {
            RevenueRegionCalibratable actualFound = addCalibrationFound(revenueRegionsActual, revenueRegionExpected);
            if (actualFound != null) {
                revenueRegionsActual.remove(actualFound);
            } else {
                addChildCalibrator(RevenueRegionCalibrator.getInstance(revenueRegionExpected, null));
            }
        }
    }

    private RevenueRegionCalibratable addCalibrationFound(List<RevenueRegionCalibratable> revenueRegionsActual, RevenueRegionCalibratable revenueRegionExpected) {
        RevenueRegionCalibratable actualFound = null;
        for (RevenueRegionCalibratable revenueRegionActual : revenueRegionsActual) {
            if (revenueRegionActual.equivalent(revenueRegionExpected)) {
                actualFound = revenueRegionActual;
                addChildCalibrator(RevenueRegionCalibrator.getInstance(revenueRegionExpected, revenueRegionActual));
                break;
            }
        }
        return actualFound;
    }

    private void addCalibrationsUnexpected(List<RevenueRegionCalibratable> revenueRegionsActual) {
        for (RevenueRegionCalibratable revenueRegionActual : revenueRegionsActual) {
            addChildCalibrator(RevenueRegionCalibrator.getInstance(null, revenueRegionActual));
        }
    }

    @Override
    protected void executeVerifications() {
        
    }
}
